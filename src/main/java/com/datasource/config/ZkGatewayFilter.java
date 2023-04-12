package com.datasource.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class ZkGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        System.out.println(queryParams.get("code"));
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


        return chain.filter(exchange.mutate().request(request).build());
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
