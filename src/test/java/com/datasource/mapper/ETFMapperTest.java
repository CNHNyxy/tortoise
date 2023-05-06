package com.datasource.mapper;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
//import okhttp3.*;
import com.datasource.entity.assetmanagement.AssetDTO;
import com.datasource.entity.vo.AssetVO;
import com.datasource.httpserver.ZKShare;
import com.datasource.util.QleUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

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

    @Autowired
    private ZKShare zkShare;

    @Test
    public void
    Asset() throws ParseException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//        Date parse = simpleDateFormat.parse("20230411");
//        Date parse1 = simpleDateFormat.parse("20230424");
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(parse1);
//        calendar.add(calendar.DATE,1);
//        parse1 = calendar.getTime();
//        System.out.println(assetMapper.getAssetList(1, 1, parse, parse1, 0, 10));
//        System.out.println(LocalDateTime.now());
//        AssetDTO assetVO = new AssetDTO();
//        assetVO.setAssetId(6);
//        assetVO.setAssetName("2222222");
//        //assetVO.setUpdateTime(LocalDateTime.now());
//        int update = assetMapper.updateById(assetVO);
//        System.out.println(update);
        List<JSONObject> zkShare1 = zkShare.getZKShare();
        for (JSONObject str : zkShare1){
            System.out.println(str.toJSONString());
        }

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
