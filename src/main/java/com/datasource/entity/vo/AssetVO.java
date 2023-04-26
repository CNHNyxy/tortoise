package com.datasource.entity.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class AssetVO {
//    private String UserName;
    private Integer assetId;
    private Integer userId;
    private Integer categoryId;
    private String assetName;
    private BigDecimal amount;
    private BigDecimal marketValue;
    private BigDecimal cost;
    private BigDecimal profit;
    private Integer currencyId;
    private String currencyName;
    private LocalDateTime createTime;
    //private LocalDateTime updateTime;
    private LocalDateTime newTime;
    private String categoryName;
}
