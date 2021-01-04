package com.example.cloudprovider.controller;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import com.example.cloudprovider.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * @author: liuhuan
 * @Description: TODO
 * @date: 2020/12/15
 */
@RestController
@RefreshScope
@EnableConfigurationProperties(User.class)
public class TestController {

    @Value("${user.name}")
    private String name;

    @Autowired
    private User user;

    @Autowired
    private NacosConfigManager nacosConfigManager;

    @PostConstruct
    public void init() {
        System.out.println("[init] value :" + name);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[destroy] value :" + name);
    }

    @GetMapping("/test")
    public String test() {
        return "value: " + name;
    }

    @GetMapping("/user")
    public String user() {
        return "provider value: " + user.toString();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            String dataId = "nacos-config-sample.properties";
            String group = "DEFAULT_GROUP";
            nacosConfigManager.getConfigService().addListener(dataId, group, new AbstractListener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("[Listener] " + configInfo);
                    System.out.println("[Before User] " + user);
                    Properties properties = new Properties();
                    try {
                        properties.load(new StringReader(configInfo));
                        String name = properties.getProperty("user.name");
                        user.setName(name);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("[After User] " + user);
                }
            });
        };
    }
}
