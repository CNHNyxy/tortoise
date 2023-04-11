package com.datasource.config;

import org.assertj.core.util.Lists;
import org.junit.platform.commons.util.StringUtils;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
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
import java.util.Arrays;
import java.util.List;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR;

@Component
public class ZkGatewayFilterFactory implements Ordered, GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        List<String> code = exchange.getRequest().getQueryParams().get("code");
        if(code ==null || code.get(0) == null || "".equals(code.get(0))){
            return chain.filter(exchange);
        }
        System.out.println("code:"+code.get(0));

        URI uri = exchange.getRequest().getURI();
        String originalQuery = uri.getRawQuery();
        System.out.println(originalQuery);
        StringBuffer stringBuffer = new StringBuffer();
        String[] split = originalQuery.split("&");
        for(String sp : split){
            if(!sp.contains("code")){
                stringBuffer.append(sp+"&");
            }
        }
        String s = stringBuffer.toString();
        s = s.substring(0,s.length() - 1);
        System.out.println(s);
        ServerHttpRequest  request = null;
        try {
            URI newUri = UriComponentsBuilder.fromUri(uri)
                    .replaceQuery(s)
                    .build(true)
                    .toUri();

            request = exchange.getRequest().mutate().uri(newUri).build();
        } catch (RuntimeException ex) {
            throw new IllegalStateException("Invalid URI query: \"" + s + "\"");
        }


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
                            System.out.println("responseData："+responseData);
                            byte[] uppedContent = new String(responseData.getBytes(), Charset.forName("UTF-8")).getBytes();
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

    @Override
    public int getOrder() {
        return -1;
    }

    public static String listStr(List<String> list){
        StringBuffer stringBuffer = new StringBuffer();
        for (String str:
             list) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

}
