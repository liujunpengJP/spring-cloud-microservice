package com.itmuch.cloud.microserviceprovideruser.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用@FeignClient("microservice-provider-user")注解绑定microservice-provider-user服务
 */
@FeignClient(name = "microservice-provider-order", fallback = UserFeignClinet.UserFeignClinetFallback.class)
public interface UserFeignClinet {

    @RequestMapping("/order")
    String queryOrderAll(@Param("jsonParam") String jsonParam);

    /**
     * 这边采取了和Spring Cloud官方文档相同的做法，
     * 将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
     */
    @Component
    class UserFeignClinetFallback implements UserFeignClinet {

        private static Log log = LogFactory.getLog(UserFeignClinetFallback.class);

        @Override
        public String queryOrderAll(String jsonParam) {
            log.info("========================microservice-provider-order模块的=[queryOrderAll]方法异常返回=============================");
            return "操作过于频繁请稍后查询！";
        }
    }
}
