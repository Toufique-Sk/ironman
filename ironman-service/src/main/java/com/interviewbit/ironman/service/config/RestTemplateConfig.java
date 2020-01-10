package com.interviewbit.ironman.service.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Toufique on 10/1/20.
 */
@Configuration
public class RestTemplateConfig {

    @Primary
    @Bean(name = "defaultRestTemplate")
    public RestTemplate restTemplate() {

        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(200);
        poolingHttpClientConnectionManager.setMaxTotal(1000);

        CloseableHttpClient closeable = HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager).build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(closeable);

        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }

}