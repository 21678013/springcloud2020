package com.hkc.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/23 15:16
 */
@RestController
@RefreshScope//动态刷新
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/config/info")
    public  String getConfigInfo(){

        return configInfo;
    }

}
