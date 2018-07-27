package com.homesoft;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class ProxyConfig {
	
	@LoadBalanced
    @Bean("proxyRestTemplate")
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
