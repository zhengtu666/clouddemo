package com.example.cloudprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudproviderApplication1 {

    public static void main(String[] args) {
        SpringApplication.run(CloudproviderApplication1.class, args);
    }

}
