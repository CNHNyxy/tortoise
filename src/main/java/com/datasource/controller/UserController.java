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
        jsonObject.put("data","111111111111");
        return jsonObject;
    }


}
