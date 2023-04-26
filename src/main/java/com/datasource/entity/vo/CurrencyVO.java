package com.datasource.entity.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CurrencyVO {
    private Integer currencyId;
    private String currencyName;
    private String currencyCode;
}
