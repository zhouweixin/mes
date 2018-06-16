package com.hnu.mes.domain;

import javax.persistence.*;

/**
 * @Author: WaveLee
 * @Date: 2018/6/15 17:36
 */
@Entity
@Table(name = "release_kiln_parameter")
public class KilnParameter {
    /**
     * 编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 窑炉工艺单编号
     */
    @ManyToOne(targetEntity = KilnOrder.class)
    @JoinColumn(name = "kiln_order_code", referencedColumnName = "code")
    private KilnOrder kilnOrder;

    /**
     * 温区
     */
    private String temRange;

    /**
     * 长度
     */
    @Column(precision = 4)
    private Double length;

    /**
     * 目标温度
     */
    private String targetTem;

    /**
     * 上温区设置温度
     */
    private String topTem;

    /**
     * 中温区设置温度
     */
    private String midTem;

    /**
     * 下温区设置温度
     */
    private String botTem;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public KilnOrder getKilnOrder() {
        return kilnOrder;
    }

    public void setKilnOrder(KilnOrder kilnOrder) {
        this.kilnOrder = kilnOrder;
    }

    public String getTemRange() {
        return temRange;
    }

    public void setTemRange(String temRange) {
        this.temRange = temRange;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public String getTargetTem() {
        return targetTem;
    }

    public void setTargetTem(String targetTem) {
        this.targetTem = targetTem;
    }

    public String getTopTem() {
        return topTem;
    }

    public void setTopTem(String topTem) {
        this.topTem = topTem;
    }

    public String getMidTem() {
        return midTem;
    }

    public void setMidTem(String midTem) {
        this.midTem = midTem;
    }

    public String getBotTem() {
        return botTem;
    }

    public void setBotTem(String botTem) {
        this.botTem = botTem;
    }

    @Override
    public String toString() {
        return "KilnParameter{" +
                "code=" + code +
                ", kilnOrder=" + kilnOrder +
                ", temRange='" + temRange + '\'' +
                ", length=" + length +
                ", targetTem='" + targetTem + '\'' +
                ", topTem='" + topTem + '\'' +
                ", midTem='" + midTem + '\'' +
                ", botTem='" + botTem + '\'' +
                '}';
    }
}
