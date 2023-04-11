package com.datasource.mapper;


import com.datasource.config.ETFBaseMapper;
import com.datasource.entity.ETF;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ETFMapper extends ETFBaseMapper<ETF> {

    //@Select("select * from fund_info")
    List<ETF> getAllETF();


}
