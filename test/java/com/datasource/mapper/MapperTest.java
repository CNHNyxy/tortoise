package com.datasource.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTest {

    @Test
    public void ETF(){
        String str = "symbol=513100&code=11111";
        StringBuffer stringBuffer = new StringBuffer();
        String[] split = str.split("&");
        for(String sp : split){
            if(!sp.contains("code")){
                stringBuffer.append(sp+"&");
            }
        }
        String s = stringBuffer.toString();
        s = s.substring(0,s.length() - 1);
        System.out.println(s);
    }

}
