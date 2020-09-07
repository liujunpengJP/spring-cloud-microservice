package com.itmuch.cloud.microserviceprovideruser.controller;

import com.alibaba.fastjson.JSONObject;
import com.itmuch.cloud.microserviceprovideruser.mapper.TUserMapper;
import com.itmuch.cloud.microserviceprovideruser.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class TestInterfaceController {

    @Autowired
    private TUserMapper userMapper;

    @RequestMapping(value = "/hello", method = { RequestMethod.POST,
            RequestMethod.GET }, produces = "application/json;charset=UTF-8")
    public String hello(){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        List<TUser> tUsers = userMapper.selectByMap(param);
        result.put("code","0");
        result.put("data",tUsers);
        return JSONObject.toJSONString(result);
    }

}
