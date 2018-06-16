package com.hnu.mes.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 21:13
 */
@Entity
@Table(name = "release_bowl_abnormal")
public class BowlAbnormal {
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
     * 装钵机号
     */
    private String bowlCode;

    /**
     * 上层
     */
    @Column(precision = 2)
    private Double top;

    /**
     * 下层
     */
    @Column(precision = 2)
    private Double bot;

    /**
     * 总重
     */
    @Column(precision = 2)
    private Double total;

    /**
     * 皮重
     */
    @Column(precision = 2)
    private Double tare;

    /**
     * 净重
     */
    @Column(precision = 2)
    private Double net;

    /**
     * 差异
     */
    @Column(precision = 2)
    private Double difference;

    /**
     * 添加/kg
     */
    @Column(precision = 2)
    private Double addWeight;

    /**
     * 减少/kg
     */
    @Column(precision = 2)
    private Double reduceWeight;

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

    public String getBowlCode() {
        return bowlCode;
    }

    public void setBowlCode(String bowlCode) {
        this.bowlCode = bowlCode;
    }

    public Double getTop() {
        return top;
    }

    public void setTop(Double top) {
        this.top = top;
    }

    public Double getBot() {
        return bot;
    }

    public void setBot(Double bot) {
        this.bot = bot;
    }

    public Double getTare() {
        return tare;
    }

    public void setTare(Double tare) {
        this.tare = tare;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getNet() {
        return net;
    }

    public void setNet(Double net) {
        this.net = net;
    }

    public Double getDifference() {
        return difference;
    }

    public void setDifference(Double difference) {
        this.difference = difference;
    }

    public Double getAddWeight() {
        return addWeight;
    }

    public void setAddWeight(Double addWeight) {
        this.addWeight = addWeight;
    }

    public Double getReduceWeight() {
        return reduceWeight;
    }

    public void setReduceWeight(Double reduceWeight) {
        this.reduceWeight = reduceWeight;
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
        return "BowlAbnormal{" +
                "code=" + code +
                ", date=" + date +
                ", dutyCode=" + dutyCode +
                ", time=" + time +
                ", bowlCode='" + bowlCode + '\'' +
                ", top=" + top +
                ", bot=" + bot +
                ", total=" + total +
                ", tare=" + tare +
                ", net=" + net +
                ", difference=" + difference +
                ", addWeight=" + addWeight +
                ", reduceWeight=" + reduceWeight +
                ", operator=" + operator +
                ", checker=" + checker +
                ", state=" + state +
                '}';
    }
}
