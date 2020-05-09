package com.example.reactivedemo.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class Fund extends Asset {

    private BigDecimal assetUnderManagement;
    private BigDecimal expenseRatio;
    private BigDecimal frontLoad;
    private String managerName;

    @Builder
    public Fund(BigDecimal assetUnderManagement, BigDecimal expenseRatio, BigDecimal frontLoad, String managerName) {
        super();
        this.assetUnderManagement = assetUnderManagement;
        this.expenseRatio = expenseRatio;
        this.frontLoad = frontLoad;
        this.managerName = managerName;
    }
}
