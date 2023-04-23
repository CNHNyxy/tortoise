package com.datasource.entity.assetmanagement;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@TableName("Asset")
@Getter
@Setter
@ToString
public class Asset{
    @TableId
    private Integer Id;
    @TableField("AssetID")
    private Integer AssetID;
    @TableField("AssetName")
    private String AssetName;
    @TableField("CategoryID")
    private Integer CategoryID;
    private BigDecimal Amount;
    @TableField("MarketValue")
    private BigDecimal MarketValue;
    private BigDecimal Cost;
    private BigDecimal Profit;
    private String Currency;
    private Date create_time;
    private Date update_time;
    private Integer is_deleted;
    private String Remarks;

}
