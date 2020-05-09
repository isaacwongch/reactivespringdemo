package com.example.reactivedemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Bond extends Asset  {
    private boolean callable;
    private LocalDate maturityDate;
    private BigDecimal couponRate;
    private BigDecimal nominal;
}
