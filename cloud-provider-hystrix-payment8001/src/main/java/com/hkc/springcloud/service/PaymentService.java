package com.hkc.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/20 13:34
 */
@Service
public class PaymentService{



    public String  paymentInfo_ok(Integer  id){

       return "线程池"+Thread.currentThread().getName()+" paymentInfo_ok,id:"+id+" O(∩_∩)O哈哈~";
    }

    /**
     * 超过3000时间就去paymentInfo_TimeOutHandle这个方法
     * @param id
     * @return
     */

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandle",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")})
    public String  paymentInfo_timeout(Integer  id){
          //int a=10/0;
        int timenumber=3000;
        try {
            TimeUnit.MILLISECONDS.sleep(timenumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+" paymentInfo_timeout,id:"+id+" O(∩_∩)O哈哈~"+" 耗时"+timenumber+"毫秒钟";
    }



    public String  paymentInfo_TimeOutHandle(Integer  id){

        return "线程池"+Thread.currentThread().getName()+" 系统繁忙或者运行出错,请稍后再试,id:"+id+" o(╥﹏╥)o";
    }
   //=============服务熔断==============
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率百分比达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer  id){

        if(id<0){
             throw  new RuntimeException("*****id不能为负数");
        }

        String  serialNumber= IdUtil.simpleUUID();
          return Thread.currentThread().getName()+" 调用成功,流水号: "+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer  id){

        return "id不能为负数,请稍后再试,o(╥﹏╥)o  id: "+id;

    }

}
