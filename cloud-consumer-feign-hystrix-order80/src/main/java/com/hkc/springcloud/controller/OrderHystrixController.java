package com.hkc.springcloud.controller;

import com.hkc.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/20 15:34
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String  paymentInfo_ok(@PathVariable("id") Integer  id){
      String  result=paymentHystrixService.paymentInfo_ok(id);

    return result;
    }

   /* @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String  paymentInfo_timeout(Integer  id){

        String  result=paymentHystrixService.paymentInfo_timeout(id);

        return  result;
    }
*/

    /**
     * 超过3000时间就去paymentInfo_TimeOutHandle这个方法
     * @param id
     * @return
     */

   /* @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandle",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")})*/



    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand
    public String  paymentInfo_timeout(Integer  id){


        int a=10/0;

        String  result=paymentHystrixService.paymentInfo_timeout(id);

        return result;
    }



    public String  paymentInfo_TimeOutHandle(Integer  id){

        return "我是消费者80,对方支付系统繁忙请稍后再试,o(╥﹏╥)o";
    }

    //全局的fallback
    public  String  payment_Global_FallbackMethod(){

        return "Global异常处理信息,请稍后再试,o(╥﹏╥)o";
    }

}
