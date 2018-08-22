package com.hnu.mes.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 8:57
 */
@Entity
@Table(name = "release_byproduct_count")
public class ByproductCount {
    /**
     * 主键ID，自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 副产品ID
     */
    @ManyToOne
    @JoinColumn(name = "byproduct_code",referencedColumnName = "code")
    private Byproduct byproductCode;

    /**
     * 批号
     */
    private String batchNumber;

    /**
     * 生产日期
     */
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    /**
     * 生产班次
     */
    @ManyToOne
    @JoinColumn(name = "duty_code",referencedColumnName = "code")
    private Duty dutyCode;

    /**
     * 重量
     */
    @Column(precision = 2)
    private Double weight;

    /**
     * 比例
     */
    @Column(precision = 6)
    private Double proportion;

    /**
     * 记录人
     */
    @ManyToOne
    @JoinColumn(name = "recorder_code",referencedColumnName = "code")
    private User recorderCode;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Byproduct getByproductCode() {
        return byproductCode;
    }

    public void setByproductCode(Byproduct byproductCode) {
        this.byproductCode = byproductCode;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Duty getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(Duty dutyCode) {
        this.dutyCode = dutyCode;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public User getRecorderCode() {
        return recorderCode;
    }

    public void setRecorderCode(User recorderCode) {
        this.recorderCode = recorderCode;
    }

    @Override
    public String toString() {
        return "ByproductCount{" +
                "code=" + code +
                ", byproductCode=" + byproductCode +
                ", batchNumber='" + batchNumber + '\'' +
                ", date=" + date +
                ", dutyCode=" + dutyCode +
                ", weight=" + weight +
                ", proportion=" + proportion +
                ", recorderCode=" + recorderCode +
                '}';
    }
}
