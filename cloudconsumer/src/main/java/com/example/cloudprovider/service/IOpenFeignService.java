package com.example.cloudprovider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: liuhuan
 * @Description: TODO
 * @date: 2020/12/15
 */
@FeignClient("demo-provider")
public interface IOpenFeignService {

    @GetMapping("/user")
    String test();
}
