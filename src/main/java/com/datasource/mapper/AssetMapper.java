package com.datasource.mapper;

import com.datasource.config.TSBaseMapper;
import com.datasource.entity.ETF;
import com.datasource.entity.assetmanagement.Asset;
import com.datasource.entity.vo.AssetCategoryVo;
import com.datasource.entity.vo.AssetVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface AssetMapper extends TSBaseMapper<Asset> {

    @Select("SELECT a.AssetName,a.Amount,a.Currency,a.create_time,a.MarketValue,a.Cost,a.Profit,u.UserName,ac.CategoryName FROM Asset a LEFT JOIN User u ON u.UserID = a.AssetID LEFT JOIN AssetCategory ac ON a.CategoryID = ac.CategoryID where u.UserID = #{UserID} and a.CategoryID = #{CategoryID} and a.create_time >= #{StartDate} and a.create_time <= #{EndDate} and a.is_deleted = 0 and ac.is_deleted = 0")
    List<AssetVo> getAssetList(int UserID, int CategoryID, Date StartDate, Date EndDate);

    @Select("select CategoryID,CategoryName from AssetCategory where is_deleted = 0")
    List<AssetCategoryVo> getAssetCategoryList();

}
