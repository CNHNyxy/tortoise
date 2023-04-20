package com.datasource.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "login",produces = "application/json;charset=UTF-8")
    public JSONObject login(@RequestBody String body){
        System.out.println(body);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",20000);
        jsonObject.put("data","111111111111");
        return jsonObject;
    }

    @GetMapping(value = "info",produces = {"application/json;charset=utf-8"})
    public JSONObject getInfo(@RequestParam(required = false) String token){
        System.out.println(token);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",20000);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("roles","111");
        jsonObject1.put("name","2222");
        jsonObject1.put("avatar","3333");
        jsonObject1.put("introduction","4444");
        jsonObject.put("data",jsonObject1);
        return jsonObject;
    }


}
