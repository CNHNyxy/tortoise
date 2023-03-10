package com.datasource.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datasource.entity.ETF;

public interface ETFBaseMapper<T> extends BaseMapper<T> {

    ETF getETCSelect();

}
