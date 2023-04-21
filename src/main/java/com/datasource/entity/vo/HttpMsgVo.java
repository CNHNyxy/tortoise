package com.datasource.entity.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class HttpMsgVo {

    private Integer code;
    private Object msg;

}
