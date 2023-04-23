package com.datasource.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.datasource.entity.assetmanagement.Asset;
import com.datasource.entity.vo.AssetCategoryVo;
import com.datasource.entity.vo.AssetVo;
import com.datasource.entity.vo.HttpMsgVo;
import com.datasource.mapper.AssetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController {

    @Autowired
    private AssetMapper assetMapper;

    @Autowired
    private HttpMsgVo httpMsg;

    @PostMapping(value = "/list",produces = "application/json;charset=UTF-8")
    public HttpMsgVo getAssetList(@RequestBody String body){
        System.out.println(body);
        JSONObject jsonObject = JSON.parseObject(body);
        Date[] dates = jsonObject.getObject("date", Date[].class);
        System.out.println(dates[0]);
        System.out.println(dates[1]);
        List<AssetVo> assetList = assetMapper.getAssetList(jsonObject.getIntValue("UserID"),jsonObject.getIntValue("CategoryID"),dates[0],dates[1]);
        System.out.println(assetList);
        httpMsg.setCode(20000);
        httpMsg.setMsg(assetList);
        return httpMsg;
    }
    @GetMapping(value = "/assetcategory",produces = "application/json;charset=UTF-8")
    public HttpMsgVo getAssetCategoryList(){
        List<AssetCategoryVo> assetCategoryList = assetMapper.getAssetCategoryList();
        httpMsg.setMsg(assetCategoryList);
        httpMsg.setCode(20000);
        return httpMsg;
    }

    @PostMapping(value = "/addasset",produces = "application/json;charset=UTF-8")
    public HttpMsgVo getAddAsset(@RequestBody String body){
        System.out.println(body);
        Asset asset = new Asset();
        Class<Asset> assetClass = Asset.class;
        T t = JSON.toJavaObject(body, assetClass);
        System.out.println(jsonObject);
        httpMsg.setMsg("");
        httpMsg.setCode(20000);
        return httpMsg;
    }

}
