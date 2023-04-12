package com.datasource.util;

import com.alibaba.fastjson.JSONObject;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Scope("singleton")
public class QleUtil {

    public static ThreadLocal<DefaultContext<String, Object>> qleLocal = new ThreadLocal<DefaultContext<String, Object>>();

    public static ExpressRunner exp = new ExpressRunner();

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public Object exec(String code,HashMap<String,Object> hashMap){
        DefaultContext<String, Object> stringObjectDefaultContext = null;
        if(qleLocal.get() == null){
            stringObjectDefaultContext = new DefaultContext<String, Object>();
        }else{
            stringObjectDefaultContext = qleLocal.get();
        }
        for (String str : hashMap.keySet()){
            stringObjectDefaultContext.put(str,hashMap.get(str));
        }
        String c = stringRedisTemplate.opsForValue().get(code);
        Object r = null;
        try {
            r = exp.execute(c, stringObjectDefaultContext, null, true, false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return r;
    }



}
