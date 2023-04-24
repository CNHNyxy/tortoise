package com.datasource.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.datasource.entity.assetmanagement.AssetDTO;
import com.datasource.entity.vo.AssetVO;
import com.datasource.mapper.AssetMapper;
import com.datasource.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    //@Autowired
    //private AssetMapper assetMapper;


    @Override
    public List<AssetVO> getAssetList(JSONObject jsonObject) {
        System.out.println(jsonObject);

        return null;
    }
}
