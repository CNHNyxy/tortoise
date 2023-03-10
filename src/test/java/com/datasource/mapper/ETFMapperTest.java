package com.datasource.mapper;


import com.datasource.entity.ETF;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ETFMapperTest {

    @Autowired
    ETFMapper etfMapper;

    @Test
    public void ETF_Inof(){
        List<ETF> allETF = etfMapper.getAllETF();
        System.out.println(allETF);
    }

}
