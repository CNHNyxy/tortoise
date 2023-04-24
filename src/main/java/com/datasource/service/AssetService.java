package com.datasource.service;

import com.alibaba.fastjson.JSONObject;
import com.datasource.entity.vo.AssetVO;

import java.util.List;

public interface AssetService {

    public List<AssetVO> getAssetList(JSONObject jsonObject);

}
