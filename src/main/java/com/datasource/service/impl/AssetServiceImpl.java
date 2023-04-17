package com.datasource.service.impl;

import com.datasource.entity.vo.AssetVo;
import com.datasource.mapper.AssetMapper;
import com.datasource.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetMapper assetMapper;


    @Override
    public List<AssetVo> getAssetList() {
        System.out.println(33333333);
        return assetMapper.getAllAsset();
    }
}
