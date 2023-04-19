package com.datasource.mapper;

import com.datasource.config.TSBaseMapper;
import com.datasource.entity.ETF;
import com.datasource.entity.assetmanagement.Asset;
import com.datasource.entity.vo.AssetVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AssetMapper extends TSBaseMapper<Asset> {

    @Select("SELECT a.AssetName,a.Amount,a.Currency,a.Date,u.UserName,ac.CategoryName FROM Asset a LEFT JOIN User u ON u.UserID = a.AssetID LEFT JOIN AssetCategory ac ON a.CategoryID = ac.CategoryID where u.UserID = #{UserID} and a.CategoryID = #{CategoryID} and a.Date >= #{StartDate} and a.Date <= #{EndDate}")
    List<AssetVo> getAssetList(int UserID,int CategoryID,String StartDate,String EndDate);
}
