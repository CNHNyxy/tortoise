package com.datasource.entity.assetmanagement;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@TableName("asset")
@Getter
@Setter
@ToString
@Data
public class AssetDTO {

    private Integer userId;
    @TableId
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
    private Integer currencyId;
    //@TableField(value = "create_time")
    private LocalDateTime createTime;
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    private LocalDateTime newTime;
    private Integer isDeleted;
    private String remarks;

}
