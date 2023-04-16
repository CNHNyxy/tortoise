package com.datasource.mapper;


import com.datasource.config.TSBaseMapper;
import com.datasource.entity.ETF;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ETFMapper extends TSBaseMapper<ETF> {

    //@Select("select * from fund_info")
    List<ETF> getAllETF();


}
