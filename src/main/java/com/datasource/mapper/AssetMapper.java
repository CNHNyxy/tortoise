package com.datasource.mapper;

import com.datasource.config.TSBaseMapper;

import com.datasource.entity.assetmanagement.AssetDTO;
import com.datasource.entity.vo.AssetCategoryVO;
import com.datasource.entity.vo.AssetVO;
import org.apache.ibatis.annotations.Select;


import java.util.Date;
import java.util.List;

public interface AssetMapper extends TSBaseMapper<AssetDTO> {
//a.create_time >= #{StartDate} and a.create_time <= #{EndDate} and
    @Select("SELECT a.asset_id,a.user_id,a.category_id,a.asset_name,a.amount,a.currency,a.create_time,a.market_value,a.cost,a.profit,u.user_name,ac.category_name FROM asset a LEFT JOIN user u ON u.user_id = a.user_id LEFT JOIN asset_category ac ON a.category_id = ac.category_id where u.user_id = #{UserID} and a.category_id = #{CategoryID} and a.is_deleted = 0 and ac.is_deleted = 0 and a.create_time >= #{startDate} and a.create_time < #{endDate} ORDER BY a.asset_id  LIMIT #{index},#{size}")
    List<AssetVO> getAssetList(int UserID, int CategoryID, Date startDate, Date endDate, int index, int size);
    //, Date StartDate, Date EndDate

    @Select("select category_id,category_name from asset_category where is_deleted = 0")
    List<AssetCategoryVO> getAssetCategoryList();

}
