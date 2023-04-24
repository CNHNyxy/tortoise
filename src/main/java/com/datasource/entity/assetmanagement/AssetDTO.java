package com.datasource.entity.assetmanagement;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@TableName("asset")
@Getter
@Setter
@ToString
public class AssetDTO {
    //@TableField(value = "UserID")
    private Integer userId;
    //@TableField("AssetID")
    private Integer assetId;
    //@TableField("AssetName")
    private String assetName;
    //@TableField("CategoryID")
    private Integer categoryId;
    private BigDecimal amount;
    //@TableField("MarketValue")
    private BigDecimal marketValue;
    private BigDecimal cost;
    private BigDecimal profit;
    private String currency;
    //@TableField(value = "create_time")
    private LocalDateTime createTime;
    //@TableField(value = "update_time")
    private LocalDateTime updateTime;
    private Integer isDeleted;
    private String remarks;

}
