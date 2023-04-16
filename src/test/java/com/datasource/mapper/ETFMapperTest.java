package com.datasource.mapper;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.datasource.entity.ETF;
//import okhttp3.*;
import com.datasource.entity.assetmanagement.Asset;
import com.datasource.util.QleUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class ETFMapperTest {

    /*@Autowired
    ETFMapper etfMapper;
*/

    @Autowired
    AssetMapper assetMapper;

    /* @Test*/
    public void ETF_Inof() {
       /* List<ETF> allETF = etfMapper.getAllETF();
        System.out.println(allETF);*/
    }

    @Test
    public void Asset(){
        System.out.println(assetMapper.getAllAsset());
    }

    /*   @Test*/
    public void ZQ() throws IOException {

        /*OkHttpClient client = new OkHttpClient();
        Request req =  new Request.Builder().url("http://fund.eastmoney.com/007227.html").get().build();;
        Response rsp = client.newCall(req).execute();
        System.out.println("响应码：" + rsp.code());
        System.out.println("响应头：" + rsp.headers());
        ResponseBody body = rsp.body();
        System.out.println(body.string());*/

    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private QleUtil qleUtil;

    @Test
    public void Qle() {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("aaa","222222");
        Object exec = qleUtil.exec("1111", stringObjectHashMap);
        System.out.println(exec);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","3333333");
        JSONArray objects = new JSONArray();
        objects.add(jsonObject);
    }
}
