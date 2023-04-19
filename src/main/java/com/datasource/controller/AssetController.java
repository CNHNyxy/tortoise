package com.datasource.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.datasource.entity.vo.AssetVo;
import com.datasource.mapper.AssetMapper;
import com.datasource.service.AssetService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController {

    @Autowired
    private AssetMapper assetMapper;

    @PostMapping(value = "/list",produces = "application/json;charset=UTF-8")
    public a getAssetList(@RequestBody String body){
        System.out.println(body);
        JSONObject jsonObject = JSON.parseObject(body);
        List<AssetVo> assetList = assetMapper.getAssetList(jsonObject.getIntValue("UserID"),jsonObject.getIntValue("CategoryID"),"20230411","20230416");
        //System.out.println(22221111);
        System.out.println(assetList);
        a a = new a();
        a.setAssetVoList(assetList);
        a.setCode(20000);
        return a;
    }

    @Getter
    @Setter
    @ToString
    class a{
        private List<AssetVo> assetVoList;
        private Integer code;
    }



}
