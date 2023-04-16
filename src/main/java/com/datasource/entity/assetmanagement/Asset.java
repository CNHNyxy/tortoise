package com.datasource.entity.assetmanagement;


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

    private Integer AssetID;
    private String AssetName;
    private Integer CategoryID;
    private BigDecimal Amount;
    private String Currency;
    private Date Date;
    private String Remarks;

}
