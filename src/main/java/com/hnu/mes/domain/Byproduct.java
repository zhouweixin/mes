package com.hnu.mes.domain;

import javax.persistence.*;

/**
 * @Author: WaveLee
 * @Date: 2018/6/21 17:27
 */
@Entity
@Table(name = "basicinfo_byproduct")
public class Byproduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    private String name;

    @ManyToOne
    @JoinColumn(name = "indicator_code",referencedColumnName = "code")
    private  Indicator indicatorCode;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Indicator getIndicatorCode() {
        return indicatorCode;
    }

    public void setIndicatorCode(Indicator indicatorCode) {
        this.indicatorCode = indicatorCode;
    }

    @Override
    public String toString() {
        return "Byproduct{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", indicatorCode=" + indicatorCode +
                '}';
    }
}
