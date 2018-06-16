package com.hnu.mes.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 21:55
 */
@Entity
@Table(name = "release_bowl_abcount")
public class BowlAbcount {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;


    /**
     * 日期
     */
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    /**
     * 班次编码
     */
    @ManyToOne
    @JoinColumn(name = "duty_code",referencedColumnName = "code")
    private Duty dutyCode;

    /**
     * 时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    /**
     * 生产批号
     */
    private String batchNumber;

    /**
     * 异常物料钵数
     */
    private Integer abNumber;

    /**
     * 异常物料重
     */
    @Column(precision = 2)
    private Double abWeight;

    /**
     * 操作人
     */
    @ManyToOne
    @JoinColumn(name = "operator_code",referencedColumnName = "code")
    private User operator;

    /**
     * 核查人
     */
    @ManyToOne
    @JoinColumn(name = "checker_code",referencedColumnName = "code")
    private User checker;

    /**
     * 状态标志
     */
    private boolean state;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Integer getAbNumber() {
        return abNumber;
    }

    public void setAbNumber(Integer abNumber) {
        this.abNumber = abNumber;
    }

    public Double getAbWeight() {
        return abWeight;
    }

    public void setAbWeight(Double abWeight) {
        this.abWeight = abWeight;
    }

    public User getOperator() {
        return operator;
    }

    public void setOperator(User operator) {
        this.operator = operator;
    }

    public User getChecker() {
        return checker;
    }

    public void setChecker(User checker) {
        this.checker = checker;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BowlAbcount{" +
                "code=" + code +
                ", date=" + date +
                ", dutyCode=" + dutyCode +
                ", time=" + time +
                ", batchNumber='" + batchNumber + '\'' +
                ", abNumber=" + abNumber +
                ", abWeight=" + abWeight +
                ", operator=" + operator +
                ", checker=" + checker +
                ", state=" + state +
                '}';
    }
}
