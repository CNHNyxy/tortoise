package com.datasource.httpserver;


//import org.springframework.cloud.openfeign.FeignClient;


import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name = "third-party-service", url = "http://43.139.3.60:8003")
public interface ZKShare {

    @GetMapping("/api/public/stock_zh_a_hist")
    List<JSONObject> getZKShare();

}
