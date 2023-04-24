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
    private Integer userId;
    private Integer categoryId;
    private String assetName;
    private BigDecimal amount;
    private BigDecimal marketValue;
    private BigDecimal cost;
    private BigDecimal profit;
    private String currency;
    private LocalDateTime createTime;
    private String categoryName;
}
