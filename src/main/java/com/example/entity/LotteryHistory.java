package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "LOTTERY_HISTORY")
public class LotteryHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer blue1;
    private Integer blue2;
    private Integer blue3;
    private Integer blue4;
    private Integer blue5;
    private Integer blue6;
    private Integer red;
    private Double sales;
    private Long firstPrizeCount;
    private Double firstPrizeAmount;
    private Long secondPrizeCount;
    private Double secondPrizeAmount;
    private Long thirdPrizeCount;
    private Double thirdPrizeAmount;
    private Double expectedValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBlue1() {
        return blue1;
    }

    public void setBlue1(Integer blue1) {
        this.blue1 = blue1;
    }

    public Integer getBlue2() {
        return blue2;
    }

    public void setBlue2(Integer blue2) {
        this.blue2 = blue2;
    }

    public Integer getBlue3() {
        return blue3;
    }

    public void setBlue3(Integer blue3) {
        this.blue3 = blue3;
    }

    public Integer getBlue4() {
        return blue4;
    }

    public void setBlue4(Integer blue4) {
        this.blue4 = blue4;
    }

    public Integer getBlue5() {
        return blue5;
    }

    public void setBlue5(Integer blue5) {
        this.blue5 = blue5;
    }

    public Integer getBlue6() {
        return blue6;
    }

    public void setBlue6(Integer blue6) {
        this.blue6 = blue6;
    }

    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Long getFirstPrizeCount() {
        return firstPrizeCount;
    }

    public void setFirstPrizeCount(Long firstPrizeCount) {
        this.firstPrizeCount = firstPrizeCount;
    }

    public Double getFirstPrizeAmount() {
        return firstPrizeAmount;
    }

    public void setFirstPrizeAmount(Double firstPrizeAmount) {
        this.firstPrizeAmount = firstPrizeAmount;
    }

    public Long getSecondPrizeCount() {
        return secondPrizeCount;
    }

    public void setSecondPrizeCount(Long secondPrizeCount) {
        this.secondPrizeCount = secondPrizeCount;
    }

    public Double getSecondPrizeAmount() {
        return secondPrizeAmount;
    }

    public void setSecondPrizeAmount(Double secondPrizeAmount) {
        this.secondPrizeAmount = secondPrizeAmount;
    }

    public Long getThirdPrizeCount() {
        return thirdPrizeCount;
    }

    public void setThirdPrizeCount(Long thirdPrizeCount) {
        this.thirdPrizeCount = thirdPrizeCount;
    }

    public Double getThirdPrizeAmount() {
        return thirdPrizeAmount;
    }

    public void setThirdPrizeAmount(Double thirdPrizeAmount) {
        this.thirdPrizeAmount = thirdPrizeAmount;
    }

    public Double getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(Double expectedValue) {
        this.expectedValue = expectedValue;
    }
}
