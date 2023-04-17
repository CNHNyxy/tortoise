package com.datasource.controller;

import com.datasource.entity.vo.AssetVo;
import com.datasource.mapper.AssetMapper;
import com.datasource.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController {

    @Autowired
    private AssetMapper assetMapper;

    @GetMapping("/list")
    public List<AssetVo> getAssetList(){
        //System.out.println(1111122222);
        List<AssetVo> assetList = assetMapper.getAllAsset();
        //System.out.println(22221111);
        System.out.println(assetList);
        return assetList;
    }




}
