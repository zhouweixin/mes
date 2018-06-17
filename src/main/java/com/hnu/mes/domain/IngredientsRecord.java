package com.hnu.mes.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 16:08
 */
@Entity
@Table(name = "release_ingredients_record")
public class IngredientsRecord {
    /**
     * 编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 配料日期
     */
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ingredientsDate;

    /**
     * 混料开始时间
     */
    private String mixBegintime;

    /**
     * 混料时间
     */
    private String mixTime;

    /**
     * 混料频率
     */
    private String mixFrequency;

    /**
     * 生产批号
     */
    private String batchNumber;

    /**
     * 配料总重量
     */
    @Column(precision = 4)
    private Double ingredientsWeight;

    /**
     * 三元前躯体编号
     */
    private String presomaCode;

    /**
     * 前躯体重量
     */
    @Column(precision = 4)
    private Double presomaWeight;

    /**
     * 碳酸锂批号
     */
    private String lithiumCode;

    /**
     * 碳酸锂重量
     */
    @Column(precision = 4)
    private Double lithiumWeight;

    /**
     * 前躯体称重
     */
    @Column(precision = 4)
    private Double presomaWeigh;

    /**
     * 前躯体皮重
     */
    @Column(precision = 4)
    private Double presomaTare;

    /**
     * 前躯体净重
     */
    @Column(precision = 4)
    private Double presomaSuttle;

    /**
     * 前躯体补加
     */
    @Column(precision = 4)
    private Double presomaAdd;

    /**
     * 碳酸锂称重
     */
    @Column(precision = 4)
    private Double lithiumWeigh;

    /**
     * 碳酸锂皮重
     */
    @Column(precision = 4)
    private Double lithiumTare;

    /**
     * 碳酸锂净重
     */
    @Column(precision = 4)
    private Double lithiumSuttle;

    /**
     * 碳酸锂补加
     */
    @Column(precision = 4)
    private Double lithiumAdd;

    /**
     * 添加剂编号
     */
    private String additiveCode;

    /**
     * 添加剂型号
     */
    private String additiveModel;

    /**
     * 添加剂重量
     */
    @Column(precision = 4)
    private Double additiveWeight;

    /**
     * 操作人
     */
    @ManyToOne
    @JoinColumn(name = "operator_code",referencedColumnName = "code")
    private User operator;

    /**
     * 监督人
     */
    @ManyToOne
    @JoinColumn(name = "supervisor_code",referencedColumnName = "code")
    private User supervisor;

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

    public Date getIngredientsDate() {
        return ingredientsDate;
    }

    public void setIngredientsDate(Date ingredientsDate) {
        this.ingredientsDate = ingredientsDate;
    }

    public String getMixBegintime() {
        return mixBegintime;
    }

    public void setMixBegintime(String mixBegintime) {
        this.mixBegintime = mixBegintime;
    }

    public String getMixTime() {
        return mixTime;
    }

    public void setMixTime(String mixTime) {
        this.mixTime = mixTime;
    }

    public String getMixFrequency() {
        return mixFrequency;
    }

    public void setMixFrequency(String mixFrequency) {
        this.mixFrequency = mixFrequency;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Double getIngredientsWeight() {
        return ingredientsWeight;
    }

    public void setIngredientsWeight(Double ingredientsWeight) {
        this.ingredientsWeight = ingredientsWeight;
    }

    public String getPresomaCode() {
        return presomaCode;
    }

    public void setPresomaCode(String presomaCode) {
        this.presomaCode = presomaCode;
    }

    public Double getPresomaWeight() {
        return presomaWeight;
    }

    public void setPresomaWeight(Double presomaWeight) {
        this.presomaWeight = presomaWeight;
    }

    public String getLithiumCode() {
        return lithiumCode;
    }

    public void setLithiumCode(String lithiumCode) {
        this.lithiumCode = lithiumCode;
    }

    public Double getLithiumWeight() {
        return lithiumWeight;
    }

    public void setLithiumWeight(Double lithiumWeight) {
        this.lithiumWeight = lithiumWeight;
    }

    public Double getPresomaWeigh() {
        return presomaWeigh;
    }

    public void setPresomaWeigh(Double presomaWeigh) {
        this.presomaWeigh = presomaWeigh;
    }

    public Double getPresomaTare() {
        return presomaTare;
    }

    public void setPresomaTare(Double presomaTare) {
        this.presomaTare = presomaTare;
    }

    public Double getPresomaSuttle() {
        return presomaSuttle;
    }

    public void setPresomaSuttle(Double presomaSuttle) {
        this.presomaSuttle = presomaSuttle;
    }

    public Double getPresomaAdd() {
        return presomaAdd;
    }

    public void setPresomaAdd(Double presomaAdd) {
        this.presomaAdd = presomaAdd;
    }

    public Double getLithiumWeigh() {
        return lithiumWeigh;
    }

    public void setLithiumWeigh(Double lithiumWeigh) {
        this.lithiumWeigh = lithiumWeigh;
    }

    public Double getLithiumTare() {
        return lithiumTare;
    }

    public void setLithiumTare(Double lithiumTare) {
        this.lithiumTare = lithiumTare;
    }

    public Double getLithiumSuttle() {
        return lithiumSuttle;
    }

    public void setLithiumSuttle(Double lithiumSuttle) {
        this.lithiumSuttle = lithiumSuttle;
    }

    public Double getLithiumAdd() {
        return lithiumAdd;
    }

    public void setLithiumAdd(Double lithiumAdd) {
        this.lithiumAdd = lithiumAdd;
    }

    public String getAdditiveCode() {
        return additiveCode;
    }

    public void setAdditiveCode(String additiveCode) {
        this.additiveCode = additiveCode;
    }

    public String getAdditiveModel() {
        return additiveModel;
    }

    public void setAdditiveModel(String additiveModel) {
        this.additiveModel = additiveModel;
    }

    public Double getAdditiveWeight() {
        return additiveWeight;
    }

    public void setAdditiveWeight(Double additiveWeight) {
        this.additiveWeight = additiveWeight;
    }

    public User getOperator() {
        return operator;
    }

    public void setOperator(User operator) {
        this.operator = operator;
    }

    public User getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "IngredientsRecord{" +
                "code=" + code +
                ", ingredientsDate=" + ingredientsDate +
                ", mixBegintime='" + mixBegintime + '\'' +
                ", mixTime='" + mixTime + '\'' +
                ", mixFrequency='" + mixFrequency + '\'' +
                ", batchNumber='" + batchNumber + '\'' +
                ", ingredientsWeight=" + ingredientsWeight +
                ", presomaCode='" + presomaCode + '\'' +
                ", presomaWeight=" + presomaWeight +
                ", lithiumCode='" + lithiumCode + '\'' +
                ", lithiumWeight=" + lithiumWeight +
                ", presomaWeigh=" + presomaWeigh +
                ", presomaTare=" + presomaTare +
                ", presomaSuttle=" + presomaSuttle +
                ", presomaAdd=" + presomaAdd +
                ", lithiumWeigh=" + lithiumWeigh +
                ", lithiumTare=" + lithiumTare +
                ", lithiumSuttle=" + lithiumSuttle +
                ", lithiumAdd=" + lithiumAdd +
                ", additiveCode='" + additiveCode + '\'' +
                ", additiveModel='" + additiveModel + '\'' +
                ", additiveWeight=" + additiveWeight +
                ", operator=" + operator +
                ", supervisor=" + supervisor +
                ", state=" + state +
                '}';
    }
}
