package com.datasource.mapper;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("fund_info")
public class ETF {

    private String code;

    private String name;

    @TableId(type = IdType.AUTO)
    private Long id;

    private Boolean is_oct;

    private Integer type;

}
