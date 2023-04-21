package com.datasource.entity.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class AssetVo {
//    private String UserName;
    private String AssetName;
    private BigDecimal Amount;
    private BigDecimal MarketValue;
    private BigDecimal Cost;
    private BigDecimal Profit;
    private String Currency;
    private java.util.Date create_time;
    private String CategoryName;
}
