package com.example.cloudprovider.controller;

import com.example.cloudprovider.service.IOpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: liuhuan
 * @Description: TODO
 * @date: 2020/12/15
 */
@RestController
public class OpenFeignController {
    @Autowired
    private IOpenFeignService openFeignService;

    @GetMapping("/test")
    public String test(){
        return openFeignService.test();
    }
}
