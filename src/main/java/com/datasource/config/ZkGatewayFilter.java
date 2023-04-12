package com.datasource.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.datasource.util.QleUtil;
import org.assertj.core.util.Lists;
import org.json.JSONString;
import org.junit.platform.commons.util.StringUtils;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR;

@Component
public class ZkGatewayFilter implements GlobalFilter, Ordered {

    @Autowired
    private QleUtil qleUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        System.out.println(queryParams.get("code"));
        String code = queryParams.get("code").get(0);
        if(queryParams.get("code") == null || "".equals(queryParams.get("code").get(0))){
            System.out.println("不走交易直接请求");
            return chain.filter(exchange);
        }
        System.out.println("走交易请求");
        URI uri = exchange.getRequest().getURI();
        String rawQuery = uri.getRawQuery();
        String[] split = rawQuery.split("&");
        StringBuffer stringBuffer = new StringBuffer();
        for(String sp:split){
            if(!sp.contains("code")){
                stringBuffer.append(sp+"&");
            }
        }
        String substring = stringBuffer.substring(0, stringBuffer.length() - 1);
        System.out.println(substring);
        URI newUri = UriComponentsBuilder.fromUri(uri)
                .replaceQuery(substring)
                .build(true)
                .toUri();
        ServerHttpRequest request = exchange.getRequest().mutate().uri(newUri).build();


        ServerHttpResponse originalResponse = exchange.getResponse();
        DataBufferFactory bufferFactory = originalResponse.bufferFactory();
        ServerHttpResponseDecorator response = new ServerHttpResponseDecorator(originalResponse) {
            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                System.out.println(1111111);
                if (getStatusCode().equals(HttpStatus.OK) && body instanceof Flux) {
                    // 获取ContentType，判断是否返回JSON格式数据
                    String originalResponseContentType = exchange.getAttribute(ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR);
                    if (StringUtils.isNotBlank(originalResponseContentType) && originalResponseContentType.contains("application/json")) {
                        Flux<? extends DataBuffer> fluxBody = Flux.from(body);
                        //（返回数据内如果字符串过大，默认会切割）解决返回体分段传输
                        return super.writeWith(fluxBody.buffer().map(dataBuffers -> {
                            List<String> list = Lists.newArrayList();
                            dataBuffers.forEach(dataBuffer -> {
                                try {
                                    byte[] content = new byte[dataBuffer.readableByteCount()];
                                    dataBuffer.read(content);
                                    DataBufferUtils.release(dataBuffer);
                                    list.add(new String(content, "utf-8"));
                                } catch (Exception e) {
                                }
                            });
                            String responseData = listStr(list);
                            //System.out.println("responseData："+responseData);
                            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
                            JSONArray rqJson = JSON.parseArray(responseData);
                            stringObjectHashMap.put("rqJson",rqJson);
                            JSONArray exec = (JSONArray)qleUtil.exec(code, stringObjectHashMap);
                            System.out.println(exec);
                            byte[] uppedContent = new String(exec.toJSONString().getBytes(), Charset.forName("UTF-8")).getBytes();
                            originalResponse.getHeaders().setContentLength(uppedContent.length);
                            return bufferFactory.wrap(uppedContent);
                        }));
                    }
                }
                return super.writeWith(body);
            }
            @Override
            public Mono<Void> writeAndFlushWith(Publisher<? extends Publisher<? extends DataBuffer>> body) {
                return writeWith(Flux.from(body).flatMapSequential(p -> p));
            }
        };
        return chain.filter(exchange.mutate().request(request).response(response).build());
    }

    public static String listStr(List<String> list){
        StringBuffer stringBuffer = new StringBuffer();
        for (String str:
                list) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    @Override
    public int getOrder() {
        return -1;
    }


}
