package com.datasource.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.datasource.entity.vo.AssetVo;
import com.datasource.entity.vo.HttpMsgVo;
import com.datasource.mapper.AssetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        List<AssetVo> assetList = assetMapper.getAssetList(jsonObject.getIntValue("UserID"),jsonObject.getIntValue("CategoryID"),"20230411","20230416");
        System.out.println(assetList);
        httpMsg.setCode(20000);
        httpMsg.setMsg(assetList);
        return httpMsg;
    }

}
