package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "LOTTERY_COMBINATION")
public class LotteryCombination {

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
}
