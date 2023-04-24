package com.datasource.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.datasource.entity.assetmanagement.AssetDTO;
import com.datasource.entity.vo.AssetCategoryVO;
import com.datasource.entity.vo.AssetVO;
import com.datasource.entity.vo.HttpMsgVo;
import com.datasource.mapper.AssetMapper;
import com.datasource.service.impl.AssetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController {

    @Autowired
    private AssetMapper assetMapper;

    @Autowired
    private AssetServiceImpl assetService;

    @Autowired
    private HttpMsgVo httpMsg;

    @PostMapping(value = "/list",produces = "application/json;charset=UTF-8")
    public HttpMsgVo getAssetList(@RequestBody String body) throws ParseException {
        System.out.println(body);
        JSONObject jsonObject = JSON.parseObject(body);
        Date[] dates = jsonObject.getObject("date", Date[].class);
        Calendar calendar = new GregorianCalendar();
        calendar.add(calendar.DATE,1);
        Date time = calendar.getTime();
        System.out.println(time);
        List<AssetVO> assetList = assetMapper.getAssetList(jsonObject.getIntValue("UserID"),jsonObject.getIntValue("CategoryID"),dates[0],time,jsonObject.getIntValue("index"),jsonObject.getIntValue("size"));
        System.out.println(assetList);
        httpMsg.setCode(20000);
        httpMsg.setMsg(assetList);
        return httpMsg;
    }
    @GetMapping(value = "/assetcategory",produces = "application/json;charset=UTF-8")
    public HttpMsgVo getAssetCategoryList(){
        List<AssetCategoryVO> assetCategoryList = assetMapper.getAssetCategoryList();
        httpMsg.setMsg(assetCategoryList);
        httpMsg.setCode(20000);
        return httpMsg;
    }

    @PostMapping(value = "/addasset",produces = "application/json;charset=UTF-8")
    public HttpMsgVo getAddAsset(@RequestBody String body){
        System.out.println(body);
        AssetDTO asset = JSON.toJavaObject(JSON.parseObject(body), AssetDTO.class);
        System.out.println(asset);
        int insert = assetMapper.insert(asset);
        httpMsg.setMsg("");
        if(insert == 1){
            httpMsg.setCode(20000);
        }else{
            httpMsg.setCode(10000);
        }
        return httpMsg;
    }

}
