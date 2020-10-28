package com.itmuch.cloud.microserviceprovideruser.controller;

import com.alibaba.fastjson.JSONObject;
import com.itmuch.cloud.microserviceprovideruser.mapper.TUserMapper;
import com.itmuch.cloud.microserviceprovideruser.pojo.TUser;
import com.itmuch.cloud.microserviceprovideruser.service.RedisConfigService;
import com.itmuch.cloud.microserviceprovideruser.service.UserFeignClinet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin
@RestController
public class TestInterfaceController {

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private RedisConfigService redisConfigService;

    @Autowired
    private UserFeignClinet userFeignClinet;

    @RequestMapping(value = "/hello", method = {RequestMethod.POST,
            RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public String query() {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> param = new HashMap<>();
        if(redisConfigService.hashKey("users")){
            System.out.print("读取redis");
            return redisConfigService.get("users");
        }else{
            List<TUser> tUsers = userMapper.selectByMap(param);
            result.put("code", "0");
            result.put("data", tUsers);
            redisConfigService.set("users",JSONObject.toJSONString(result),60 * 30);
        }
        return JSONObject.toJSONString(result);
    }

    @ResponseBody
    @RequestMapping(value = "/queryOrder", method = {RequestMethod.POST,
            RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public String queryOrder() {
        String orderAll = userFeignClinet.queryOrderAll("测试");
        return orderAll;
    }
}
