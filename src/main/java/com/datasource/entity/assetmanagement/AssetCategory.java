package com.datasource.entity.assetmanagement;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@TableName("AssetCategory")
@Getter
@Setter
@ToString
public class AssetCategory {
    private int categoryId;
    private String categoryName;
}
