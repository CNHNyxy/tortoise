package com.datasource.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@TableName("User")
@Getter
@Setter
@ToString
public class User {
    private int userId;
    private String userName;
    private String password;
    private String email;
}


