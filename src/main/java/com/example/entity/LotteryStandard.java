package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LOTTERY_STANDARD")
public class LotteryStandard {

    private Double historyBlue1Avg;
    private Double historyVariance;
    private Double historyStandardDiviation;
    private Double historyCovariance;

}
