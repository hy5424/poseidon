package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "LOTTERY_STANDARD")
public class LotteryStandard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double historyBlue1Avg;
    private Double historyBlue1Variance;
    private Double historyBlue1StandardDiviation;
    private Double historyBlue1Covariance;
    private Double historyBlue2Avg;
    private Double historyBlue2Variance;
    private Double historyBlue2StandardDiviation;
    private Double historyBlue2Covariance;
    private Double historyBlue3Avg;
    private Double historyBlue3Variance;
    private Double historyBlue3StandardDiviation;
    private Double historyBlue3Covariance;
    private Double historyBlue4Avg;
    private Double historyBlue4Variance;
    private Double historyBlue4StandardDiviation;
    private Double historyBlue4Covariance;
    private Double historyBlue5Avg;
    private Double historyBlue5Variance;
    private Double historyBlue5StandardDiviation;
    private Double historyBlue5Covariance;
    private Double historyBlue6Avg;
    private Double historyBlue6Variance;
    private Double historyBlue6StandardDiviation;
    private Double historyBlue6Covariance;
    private Double historyRedAvg;
    private Double historyRedVariance;
    private Double historyRedStandardDiviation;
    private Double historyRedCovariance;
    private Double combinBlue1Avg;
    private Double combinBlue1Variance;
    private Double combinBlue1StandardDiviation;
    private Double combinBlue1Covariance;
    private Double combinBlue2Avg;
    private Double combinBlue2Variance;
    private Double combinBlue2StandardDiviation;
    private Double combinBlue2Covariance;
    private Double combinBlue3Avg;
    private Double combinBlue3Variance;
    private Double combinBlue3StandardDiviation;
    private Double combinBlue3Covariance;
    private Double combinBlue4Avg;
    private Double combinBlue4Variance;
    private Double combinBlue4StandardDiviation;
    private Double combinBlue4Covariance;
    private Double combinBlue5Avg;
    private Double combinBlue5Variance;
    private Double combinBlue5StandardDiviation;
    private Double combinBlue5Covariance;
    private Double combinBlue6Avg;
    private Double combinBlue6Variance;
    private Double combinBlue6StandardDiviation;
    private Double combinBlue6Covariance;
    private Double combinRedAvg;
    private Double combinRedVariance;
    private Double combinRedStandardDiviation;
    private Double combinRedCovariance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getHistoryBlue1Avg() {
        return historyBlue1Avg;
    }

    public void setHistoryBlue1Avg(Double historyBlue1Avg) {
        this.historyBlue1Avg = historyBlue1Avg;
    }

    public Double getHistoryBlue1Variance() {
        return historyBlue1Variance;
    }

    public void setHistoryBlue1Variance(Double historyBlue1Variance) {
        this.historyBlue1Variance = historyBlue1Variance;
    }

    public Double getHistoryBlue1StandardDiviation() {
        return historyBlue1StandardDiviation;
    }

    public void setHistoryBlue1StandardDiviation(Double historyBlue1StandardDiviation) {
        this.historyBlue1StandardDiviation = historyBlue1StandardDiviation;
    }

    public Double getHistoryBlue1Covariance() {
        return historyBlue1Covariance;
    }

    public void setHistoryBlue1Covariance(Double historyBlue1Covariance) {
        this.historyBlue1Covariance = historyBlue1Covariance;
    }

    public Double getHistoryBlue2Avg() {
        return historyBlue2Avg;
    }

    public void setHistoryBlue2Avg(Double historyBlue2Avg) {
        this.historyBlue2Avg = historyBlue2Avg;
    }

    public Double getHistoryBlue2Variance() {
        return historyBlue2Variance;
    }

    public void setHistoryBlue2Variance(Double historyBlue2Variance) {
        this.historyBlue2Variance = historyBlue2Variance;
    }

    public Double getHistoryBlue2StandardDiviation() {
        return historyBlue2StandardDiviation;
    }

    public void setHistoryBlue2StandardDiviation(Double historyBlue2StandardDiviation) {
        this.historyBlue2StandardDiviation = historyBlue2StandardDiviation;
    }

    public Double getHistoryBlue2Covariance() {
        return historyBlue2Covariance;
    }

    public void setHistoryBlue2Covariance(Double historyBlue2Covariance) {
        this.historyBlue2Covariance = historyBlue2Covariance;
    }

    public Double getHistoryBlue3Avg() {
        return historyBlue3Avg;
    }

    public void setHistoryBlue3Avg(Double historyBlue3Avg) {
        this.historyBlue3Avg = historyBlue3Avg;
    }

    public Double getHistoryBlue3Variance() {
        return historyBlue3Variance;
    }

    public void setHistoryBlue3Variance(Double historyBlue3Variance) {
        this.historyBlue3Variance = historyBlue3Variance;
    }

    public Double getHistoryBlue3StandardDiviation() {
        return historyBlue3StandardDiviation;
    }

    public void setHistoryBlue3StandardDiviation(Double historyBlue3StandardDiviation) {
        this.historyBlue3StandardDiviation = historyBlue3StandardDiviation;
    }

    public Double getHistoryBlue3Covariance() {
        return historyBlue3Covariance;
    }

    public void setHistoryBlue3Covariance(Double historyBlue3Covariance) {
        this.historyBlue3Covariance = historyBlue3Covariance;
    }

    public Double getHistoryBlue4Avg() {
        return historyBlue4Avg;
    }

    public void setHistoryBlue4Avg(Double historyBlue4Avg) {
        this.historyBlue4Avg = historyBlue4Avg;
    }

    public Double getHistoryBlue4Variance() {
        return historyBlue4Variance;
    }

    public void setHistoryBlue4Variance(Double historyBlue4Variance) {
        this.historyBlue4Variance = historyBlue4Variance;
    }

    public Double getHistoryBlue4StandardDiviation() {
        return historyBlue4StandardDiviation;
    }

    public void setHistoryBlue4StandardDiviation(Double historyBlue4StandardDiviation) {
        this.historyBlue4StandardDiviation = historyBlue4StandardDiviation;
    }

    public Double getHistoryBlue4Covariance() {
        return historyBlue4Covariance;
    }

    public void setHistoryBlue4Covariance(Double historyBlue4Covariance) {
        this.historyBlue4Covariance = historyBlue4Covariance;
    }

    public Double getHistoryBlue5Avg() {
        return historyBlue5Avg;
    }

    public void setHistoryBlue5Avg(Double historyBlue5Avg) {
        this.historyBlue5Avg = historyBlue5Avg;
    }

    public Double getHistoryBlue5Variance() {
        return historyBlue5Variance;
    }

    public void setHistoryBlue5Variance(Double historyBlue5Variance) {
        this.historyBlue5Variance = historyBlue5Variance;
    }

    public Double getHistoryBlue5StandardDiviation() {
        return historyBlue5StandardDiviation;
    }

    public void setHistoryBlue5StandardDiviation(Double historyBlue5StandardDiviation) {
        this.historyBlue5StandardDiviation = historyBlue5StandardDiviation;
    }

    public Double getHistoryBlue5Covariance() {
        return historyBlue5Covariance;
    }

    public void setHistoryBlue5Covariance(Double historyBlue5Covariance) {
        this.historyBlue5Covariance = historyBlue5Covariance;
    }

    public Double getHistoryBlue6Avg() {
        return historyBlue6Avg;
    }

    public void setHistoryBlue6Avg(Double historyBlue6Avg) {
        this.historyBlue6Avg = historyBlue6Avg;
    }

    public Double getHistoryBlue6Variance() {
        return historyBlue6Variance;
    }

    public void setHistoryBlue6Variance(Double historyBlue6Variance) {
        this.historyBlue6Variance = historyBlue6Variance;
    }

    public Double getHistoryBlue6StandardDiviation() {
        return historyBlue6StandardDiviation;
    }

    public void setHistoryBlue6StandardDiviation(Double historyBlue6StandardDiviation) {
        this.historyBlue6StandardDiviation = historyBlue6StandardDiviation;
    }

    public Double getHistoryBlue6Covariance() {
        return historyBlue6Covariance;
    }

    public void setHistoryBlue6Covariance(Double historyBlue6Covariance) {
        this.historyBlue6Covariance = historyBlue6Covariance;
    }

    public Double getHistoryRedAvg() {
        return historyRedAvg;
    }

    public void setHistoryRedAvg(Double historyRedAvg) {
        this.historyRedAvg = historyRedAvg;
    }

    public Double getHistoryRedVariance() {
        return historyRedVariance;
    }

    public void setHistoryRedVariance(Double historyRedVariance) {
        this.historyRedVariance = historyRedVariance;
    }

    public Double getHistoryRedStandardDiviation() {
        return historyRedStandardDiviation;
    }

    public void setHistoryRedStandardDiviation(Double historyRedStandardDiviation) {
        this.historyRedStandardDiviation = historyRedStandardDiviation;
    }

    public Double getHistoryRedCovariance() {
        return historyRedCovariance;
    }

    public void setHistoryRedCovariance(Double historyRedCovariance) {
        this.historyRedCovariance = historyRedCovariance;
    }

    public Double getCombinBlue1Avg() {
        return combinBlue1Avg;
    }

    public void setCombinBlue1Avg(Double combinBlue1Avg) {
        this.combinBlue1Avg = combinBlue1Avg;
    }

    public Double getCombinBlue1Variance() {
        return combinBlue1Variance;
    }

    public void setCombinBlue1Variance(Double combinBlue1Variance) {
        this.combinBlue1Variance = combinBlue1Variance;
    }

    public Double getCombinBlue1StandardDiviation() {
        return combinBlue1StandardDiviation;
    }

    public void setCombinBlue1StandardDiviation(Double combinBlue1StandardDiviation) {
        this.combinBlue1StandardDiviation = combinBlue1StandardDiviation;
    }

    public Double getCombinBlue1Covariance() {
        return combinBlue1Covariance;
    }

    public void setCombinBlue1Covariance(Double combinBlue1Covariance) {
        this.combinBlue1Covariance = combinBlue1Covariance;
    }

    public Double getCombinBlue2Avg() {
        return combinBlue2Avg;
    }

    public void setCombinBlue2Avg(Double combinBlue2Avg) {
        this.combinBlue2Avg = combinBlue2Avg;
    }

    public Double getCombinBlue2Variance() {
        return combinBlue2Variance;
    }

    public void setCombinBlue2Variance(Double combinBlue2Variance) {
        this.combinBlue2Variance = combinBlue2Variance;
    }

    public Double getCombinBlue2StandardDiviation() {
        return combinBlue2StandardDiviation;
    }

    public void setCombinBlue2StandardDiviation(Double combinBlue2StandardDiviation) {
        this.combinBlue2StandardDiviation = combinBlue2StandardDiviation;
    }

    public Double getCombinBlue2Covariance() {
        return combinBlue2Covariance;
    }

    public void setCombinBlue2Covariance(Double combinBlue2Covariance) {
        this.combinBlue2Covariance = combinBlue2Covariance;
    }

    public Double getCombinBlue3Avg() {
        return combinBlue3Avg;
    }

    public void setCombinBlue3Avg(Double combinBlue3Avg) {
        this.combinBlue3Avg = combinBlue3Avg;
    }

    public Double getCombinBlue3Variance() {
        return combinBlue3Variance;
    }

    public void setCombinBlue3Variance(Double combinBlue3Variance) {
        this.combinBlue3Variance = combinBlue3Variance;
    }

    public Double getCombinBlue3StandardDiviation() {
        return combinBlue3StandardDiviation;
    }

    public void setCombinBlue3StandardDiviation(Double combinBlue3StandardDiviation) {
        this.combinBlue3StandardDiviation = combinBlue3StandardDiviation;
    }

    public Double getCombinBlue3Covariance() {
        return combinBlue3Covariance;
    }

    public void setCombinBlue3Covariance(Double combinBlue3Covariance) {
        this.combinBlue3Covariance = combinBlue3Covariance;
    }

    public Double getCombinBlue4Avg() {
        return combinBlue4Avg;
    }

    public void setCombinBlue4Avg(Double combinBlue4Avg) {
        this.combinBlue4Avg = combinBlue4Avg;
    }

    public Double getCombinBlue4Variance() {
        return combinBlue4Variance;
    }

    public void setCombinBlue4Variance(Double combinBlue4Variance) {
        this.combinBlue4Variance = combinBlue4Variance;
    }

    public Double getCombinBlue4StandardDiviation() {
        return combinBlue4StandardDiviation;
    }

    public void setCombinBlue4StandardDiviation(Double combinBlue4StandardDiviation) {
        this.combinBlue4StandardDiviation = combinBlue4StandardDiviation;
    }

    public Double getCombinBlue4Covariance() {
        return combinBlue4Covariance;
    }

    public void setCombinBlue4Covariance(Double combinBlue4Covariance) {
        this.combinBlue4Covariance = combinBlue4Covariance;
    }

    public Double getCombinBlue5Avg() {
        return combinBlue5Avg;
    }

    public void setCombinBlue5Avg(Double combinBlue5Avg) {
        this.combinBlue5Avg = combinBlue5Avg;
    }

    public Double getCombinBlue5Variance() {
        return combinBlue5Variance;
    }

    public void setCombinBlue5Variance(Double combinBlue5Variance) {
        this.combinBlue5Variance = combinBlue5Variance;
    }

    public Double getCombinBlue5StandardDiviation() {
        return combinBlue5StandardDiviation;
    }

    public void setCombinBlue5StandardDiviation(Double combinBlue5StandardDiviation) {
        this.combinBlue5StandardDiviation = combinBlue5StandardDiviation;
    }

    public Double getCombinBlue5Covariance() {
        return combinBlue5Covariance;
    }

    public void setCombinBlue5Covariance(Double combinBlue5Covariance) {
        this.combinBlue5Covariance = combinBlue5Covariance;
    }

    public Double getCombinBlue6Avg() {
        return combinBlue6Avg;
    }

    public void setCombinBlue6Avg(Double combinBlue6Avg) {
        this.combinBlue6Avg = combinBlue6Avg;
    }

    public Double getCombinBlue6Variance() {
        return combinBlue6Variance;
    }

    public void setCombinBlue6Variance(Double combinBlue6Variance) {
        this.combinBlue6Variance = combinBlue6Variance;
    }

    public Double getCombinBlue6StandardDiviation() {
        return combinBlue6StandardDiviation;
    }

    public void setCombinBlue6StandardDiviation(Double combinBlue6StandardDiviation) {
        this.combinBlue6StandardDiviation = combinBlue6StandardDiviation;
    }

    public Double getCombinBlue6Covariance() {
        return combinBlue6Covariance;
    }

    public void setCombinBlue6Covariance(Double combinBlue6Covariance) {
        this.combinBlue6Covariance = combinBlue6Covariance;
    }

    public Double getCombinRedAvg() {
        return combinRedAvg;
    }

    public void setCombinRedAvg(Double combinRedAvg) {
        this.combinRedAvg = combinRedAvg;
    }

    public Double getCombinRedVariance() {
        return combinRedVariance;
    }

    public void setCombinRedVariance(Double combinRedVariance) {
        this.combinRedVariance = combinRedVariance;
    }

    public Double getCombinRedStandardDiviation() {
        return combinRedStandardDiviation;
    }

    public void setCombinRedStandardDiviation(Double combinRedStandardDiviation) {
        this.combinRedStandardDiviation = combinRedStandardDiviation;
    }

    public Double getCombinRedCovariance() {
        return combinRedCovariance;
    }

    public void setCombinRedCovariance(Double combinRedCovariance) {
        this.combinRedCovariance = combinRedCovariance;
    }
}
