package com.example.cloudprovider.service;

import com.duia.dubbo.bang.api.model.DuibaDubboGroupTopic;
import com.duia.dubbo.bang.api.response.ResultResponse;
import com.duia.dubbo.bang.api.service.IDuibaGroupTopicDubboService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author: liuhuan
 * @Description: TODO
 * @date: 2020/12/15
 */
@DubboService
public class DubboCloudTestService implements IDuibaGroupTopicDubboService {

    public ResultResponse<DuibaDubboGroupTopic> getLatestTopTopic(Integer sku) {
        ResultResponse<DuibaDubboGroupTopic> response = new ResultResponse<DuibaDubboGroupTopic>();
        response.setCode(1);
        response.setMessage("provider1");
        return response;
    }
}
