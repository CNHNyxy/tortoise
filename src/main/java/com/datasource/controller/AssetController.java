package com.datasource.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.datasource.entity.vo.AssetVo;
import com.datasource.mapper.AssetMapper;
import com.datasource.service.AssetService;
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
    public List<AssetVo> getAssetList(@RequestBody String body){
        JSONObject jsonObject = JSON.parseObject(body);
        List<AssetVo> assetList = assetMapper.getAssetList(jsonObject.getIntValue("UserID"),jsonObject.getIntValue("CategoryID"),"20230411","20230416");
        //System.out.println(22221111);
        System.out.println(assetList);
        return assetList;
    }




}
