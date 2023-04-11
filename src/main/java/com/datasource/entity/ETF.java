package com.datasource.entity;


//import com.baomidou.mybatisplus.annotation.*;
//import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.time.LocalDateTime;


//@TableName("fund_info")
public class ETF implements Serializable {

    private String code;

    private String name;

    //@TableId(type = IdType.AUTO)
    private Long id;

    private Boolean is_oct;

    //@TableField(jdbcType = JdbcType.INTEGER)
    private Integer type;

    //@TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    //@TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIs_oct() {
        return is_oct;
    }

    public void setIs_oct(Boolean is_oct) {
        this.is_oct = is_oct;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ETF{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", is_oct=" + is_oct +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
