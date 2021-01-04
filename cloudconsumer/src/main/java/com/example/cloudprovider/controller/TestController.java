package com.example.cloudprovider.controller;

import com.duia.dubbo.bang.api.model.DuibaDubboGroupTopic;
import com.duia.dubbo.bang.api.response.ResultResponse;
import com.duia.dubbo.bang.api.service.IDuibaGroupTopicDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuhuan
 * @Description: TODO
 * @date: 2020/12/15
 */
@RestController
public class TestController {

    @DubboReference
    private IDuibaGroupTopicDubboService duibaGroupTopicDubboService;

    @GetMapping("/dubboTest")
    public ResultResponse<DuibaDubboGroupTopic> test() {
        return duibaGroupTopicDubboService.getLatestTopTopic(1);
    }
}
