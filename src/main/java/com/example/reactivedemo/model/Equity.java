package com.example.reactivedemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Equity extends Asset {
    private BigDecimal peRatio;
    private BigDecimal pbRatio;
    private int volume;
}
