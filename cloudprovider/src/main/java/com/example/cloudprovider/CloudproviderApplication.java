package com.example.cloudprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudproviderApplication.class, args);
    }

}
