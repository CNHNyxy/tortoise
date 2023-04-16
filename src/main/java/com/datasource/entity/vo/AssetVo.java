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
    private String userName;
    private String AssetName;
    private BigDecimal Amount;
    private String Currency;
    private java.util.Date Date;
    private String categoryName;
}
