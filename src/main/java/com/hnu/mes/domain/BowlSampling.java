package com.hnu.mes.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 20:36
 */
@Entity
@Table(name = "release_bowl_sampling")
public class BowlSampling {
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
     * 装钵机号
     */
    private String bowlCode;

    /**
     * 皮重
     */
    @Column(precision = 2)
    private Double tare;

    /**
     * 总重
     */
    @Column(precision = 2)
    private Double total;

    /**
     * 净重
     */
    @Column(precision = 2)
    private Double net;

    /**
     * 抽检人
     */
    @ManyToOne
    @JoinColumn(name = "random_code",referencedColumnName = "code")
    private User random;

    /**
     * 抽检时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date randomTime;

    /**
     * 检查人
     */
    @ManyToOne
    @JoinColumn(name = "inspector_code",referencedColumnName = "code")
    private User inspector;

    /**
     * 检查时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inspectorTime;

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

    public String getBowlCode() {
        return bowlCode;
    }

    public void setBowlCode(String bowlCode) {
        this.bowlCode = bowlCode;
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

    public User getRandom() {
        return random;
    }

    public void setRandom(User random) {
        this.random = random;
    }

    public Date getRandomTime() {
        return randomTime;
    }

    public void setRandomTime(Date randomTime) {
        this.randomTime = randomTime;
    }

    public User getInspector() {
        return inspector;
    }

    public void setInspector(User inspector) {
        this.inspector = inspector;
    }

    public Date getInspectorTime() {
        return inspectorTime;
    }

    public void setInspectorTime(Date inspectorTime) {
        this.inspectorTime = inspectorTime;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BowlSampling{" +
                "code=" + code +
                ", date=" + date +
                ", dutyCode=" + dutyCode +
                ", bowlCode='" + bowlCode + '\'' +
                ", tare=" + tare +
                ", total=" + total +
                ", net=" + net +
                ", random=" + random +
                ", randomTime=" + randomTime +
                ", inspector=" + inspector +
                ", inspectorTime=" + inspectorTime +
                ", state=" + state +
                '}';
    }
}
