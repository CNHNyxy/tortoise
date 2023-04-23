package com.datasource.mapper;


import com.alibaba.fastjson.JSON;
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
import java.math.BigDecimal;
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
        //System.out.println(assetMapper.getAllAsset());
        Asset asset = new Asset();
        asset.setAssetName("11111");
        asset.setAssetID(1);
        asset.setCurrency("11111");
        asset.setCost(new BigDecimal("1111"));
        asset.setAmount(new BigDecimal("1111"));
        asset.setProfit(new BigDecimal("11111"));
        asset.setMarketValue(new BigDecimal("11111"));
        asset.setRemarks("11111");
        asset.setCategoryID(1);

        int insert = assetMapper.insert(asset);
        System.out.println(insert);
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
        JSONArray rq = new JSONArray();
        JSONArray rp = new JSONArray();
        JSONObject[] jolist = (JSONObject[])rq.toArray();
        JSONObject rps = null;
        for(int i = 0;i<jolist.length;i++){
            rps = new JSONObject();
            rps.put("name",jolist[i].get("名称"));
            rps.put("code",jolist[i].get("代码"));
            rp.add(rps);
        }
        String s = rp.toJSONString();
    }
}
