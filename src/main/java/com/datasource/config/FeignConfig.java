package com.datasource.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

import feign.codec.Decoder;
import feign.codec.Encoder;

@Configuration
public class FeignConfig {

    @Bean
    public Decoder feignDecoder() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJackson2HttpMessageConverter());
        HttpMessageConverters httpMessageConverters = new HttpMessageConverters(false, converters);
        return new SpringDecoder(() -> httpMessageConverters);
    }

    @Bean
    public Encoder feignEncoder() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJackson2HttpMessageConverter());
        HttpMessageConverters httpMessageConverters = new HttpMessageConverters(false, converters);
        return new SpringEncoder(() -> httpMessageConverters);
    }
}
