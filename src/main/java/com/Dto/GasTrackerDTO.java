package com.example.springboot_fastweb.web3config;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author justin
 * @create 2022-03-21 20-01
 */
@Data
public class GasTrackerDTO {
    public Object[] reward;
    public BigInteger blockNumber;
    public BigDecimal baseFeePerGas;
    public String gasUsedRatio;
}
