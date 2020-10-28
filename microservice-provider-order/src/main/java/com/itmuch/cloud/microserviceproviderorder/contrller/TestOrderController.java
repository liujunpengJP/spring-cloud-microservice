package com.itmuch.cloud.microserviceproviderorder.contrller;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestOrderController {

    @ResponseBody
    @RequestMapping(value = "/queryOrder", method = {RequestMethod.POST,
            RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public String queryOrder(@RequestParam String jsonParam) {
        if (StringUtils.isNotBlank(jsonParam)) {
            return jsonParam;
        }
        System.out.print("=========order=========");
        return "order";
    }
}
