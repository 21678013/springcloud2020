package com.hkc.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/22 11:05
 */
@RestController
@RefreshScope
public class ConfigClientController {


    @Value("${config.info}")
    private String  configInfo;

    @GetMapping(value = "/configInfo")
    public  String  getConfigInfo(){


       return  configInfo;
    }

}
