package com.hnu.mes.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: WaveLee
 * @Date: 2018/6/14 21:03
 */
@Entity
@Table(name = "release_pro_order")
public class ProductOrder {
    /**
     * 编码
     * 主键，非空
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 生产批号
     */
    private String batchNumber;

    /**
     * 生产线编码
     */
    @ManyToOne
    @JoinColumn(name = "product_line_code",referencedColumnName = "code")
    private ProductLine productLineCode;

    /**
     * 计划投入量
     */
    @Column(precision = 2)
    private Double inputPlan;

    /**
     * 投入日期
     */
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputDate;

    /**
     * 生产流水号
     */
    private String serialNumber;

    /**
     * 前躯体原料批号
     */
    private String presomaCode;

    /**
     * 前躯体主含%
     */
    @Column(precision = 2)
    private Double presomaContent;

    /**
     * 前躯体配比量/Kg
     */
    private String presomaRatio;

    /**
     * 碳酸锂原料批号
     */
    private String lithiumCode;

    /**
     * 碳酸锂主含%
     */
    @Column(precision = 2)
    private Double lithiumContent;

    /**
     * 碳酸锂配比量/Kg
     */
    private String lithiumRatio;

    /**
     * 添加剂编号
     */
    private String additiveCode;

    /**
     * 添加剂重量
     */
    @Column(precision = 2)
    private Double additiveWeight;

    /**
     * 目标锂含量%
     */
    @Column(precision = 2)
    private Double targetLithium;

    /**
     * 前躯体投放总量/Kg
     */
    @Column(precision = 2)
    private Double presomaWeight;

    /**
     * 碳酸锂投料总量/Kg
     */
    @Column(precision = 2)
    private Double lithiumWeight;

    /**
     * 混料频率
     */
    @Column(precision = 2)
    private Double mixFrequency;

    /**
     * 混料时间
     */
    private Integer mixDate;

    /**
     * 混料生产过程要求
     */
    private String mixRequirements;

    /**
     * 混料生产过程检测
     */
    private String mixDetection;

    /**
     * 预烧生产计划组织
     */
    private String presinteringPlan;

    /**
     * 预烧生产工艺参数
     */
    private String presinteringParameter;

    /**
     * 预烧生产过程要求
     */
    private String presinteringRequirements;

    /**
     * 预烧生产过程检测
     */
    private String presinteringDetection;

    /**
     * 编制人
     */
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "compactor_code", referencedColumnName = "code")
    private User compactor;

    /**
     * 审核人
     */
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "auditor_code", referencedColumnName = "code")
    private User auditor;

    /**
     * 执行人
     */
    @ManyToOne
    @JoinColumn(name = "executor_code", referencedColumnName = "code")
    private User executor;

    /**
     * 品管
     */
    @ManyToOne
    @JoinColumn(name = "qc_code", referencedColumnName = "code")
    private User qc;

    /**
     * 编制时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date compileTime;

    /**
     * 状态标志 0未提交，1已提交
     */
    private boolean state;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public ProductLine getProductLineCode() {
        return productLineCode;
    }

    public void setProductLineCode(ProductLine productLineCode) {
        this.productLineCode = productLineCode;
    }

    public Double getInputPlan() {
        return inputPlan;
    }

    public void setInputPlan(Double inputPlan) {
        this.inputPlan = inputPlan;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPresomaCode() {
        return presomaCode;
    }

    public void setPresomaCode(String presomaCode) {
        this.presomaCode = presomaCode;
    }

    public Double getPresomaContent() {
        return presomaContent;
    }

    public void setPresomaContent(Double presomaContent) {
        this.presomaContent = presomaContent;
    }

    public String getLithiumCode() {
        return lithiumCode;
    }

    public void setLithiumCode(String lithiumCode) {
        this.lithiumCode = lithiumCode;
    }

    public Double getLithiumContent() {
        return lithiumContent;
    }

    public void setLithiumContent(Double lithiumContent) {
        this.lithiumContent = lithiumContent;
    }

    public String getPresomaRatio() {
        return presomaRatio;
    }

    public void setPresomaRatio(String presomaRatio) {
        this.presomaRatio = presomaRatio;
    }

    public String getLithiumRatio() {
        return lithiumRatio;
    }

    public void setLithiumRatio(String lithiumRatio) {
        this.lithiumRatio = lithiumRatio;
    }

    public String getAdditiveCode() {
        return additiveCode;
    }

    public void setAdditiveCode(String additiveCode) {
        this.additiveCode = additiveCode;
    }

    public Double getAdditiveWeight() {
        return additiveWeight;
    }

    public void setAdditiveWeight(Double additiveWeight) {
        this.additiveWeight = additiveWeight;
    }

    public Double getTargetLithium() {
        return targetLithium;
    }

    public void setTargetLithium(Double targetLithium) {
        this.targetLithium = targetLithium;
    }

    public Double getPresomaWeight() {
        return presomaWeight;
    }

    public void setPresomaWeight(Double presomaWeight) {
        this.presomaWeight = presomaWeight;
    }

    public Double getLithiumWeight() {
        return lithiumWeight;
    }

    public void setLithiumWeight(Double lithiumWeight) {
        this.lithiumWeight = lithiumWeight;
    }

    public Double getMixFrequency() {
        return mixFrequency;
    }

    public void setMixFrequency(Double mixFrequency) {
        this.mixFrequency = mixFrequency;
    }

    public Integer getMixDate() {
        return mixDate;
    }

    public void setMixDate(Integer mixDate) {
        this.mixDate = mixDate;
    }

    public String getMixRequirements() {
        return mixRequirements;
    }

    public void setMixRequirements(String mixRequirements) {
        this.mixRequirements = mixRequirements;
    }

    public String getMixDetection() {
        return mixDetection;
    }

    public void setMixDetection(String mixDetection) {
        this.mixDetection = mixDetection;
    }

    public String getPresinteringPlan() {
        return presinteringPlan;
    }

    public void setPresinteringPlan(String presinteringPlan) {
        this.presinteringPlan = presinteringPlan;
    }

    public String getPresinteringParameter() {
        return presinteringParameter;
    }

    public void setPresinteringParameter(String presinteringParameter) {
        this.presinteringParameter = presinteringParameter;
    }

    public String getPresinteringRequirements() {
        return presinteringRequirements;
    }

    public void setPresinteringRequirements(String presinteringRequirements) {
        this.presinteringRequirements = presinteringRequirements;
    }

    public String getPresinteringDetection() {
        return presinteringDetection;
    }

    public void setPresinteringDetection(String presinteringDetection) {
        this.presinteringDetection = presinteringDetection;
    }

    public User getCompactor() {
        return compactor;
    }

    public void setCompactor(User compactor) {
        this.compactor = compactor;
    }

    public User getAuditor() {
        return auditor;
    }

    public void setAuditor(User auditor) {
        this.auditor = auditor;
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    public User getQc() {
        return qc;
    }

    public void setQc(User qc) {
        this.qc = qc;
    }

    public Date getCompileTime() {
        return compileTime;
    }

    public void setCompileTime(Date compileTime) {
        this.compileTime = compileTime;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "code=" + code +
                ", batchNumber='" + batchNumber + '\'' +
                ", productLineCode=" + productLineCode +
                ", inputPlan=" + inputPlan +
                ", inputDate=" + inputDate +
                ", serialNumber='" + serialNumber + '\'' +
                ", presomaCode='" + presomaCode + '\'' +
                ", presomaContent=" + presomaContent +
                ", presomaRatio=" + presomaRatio +
                ", lithiumCode='" + lithiumCode + '\'' +
                ", lithiumContent=" + lithiumContent +
                ", lithiumRatio=" + lithiumRatio +
                ", additiveCode='" + additiveCode + '\'' +
                ", additiveWeight=" + additiveWeight +
                ", targetLithium=" + targetLithium +
                ", presomaWeight=" + presomaWeight +
                ", lithiumWeight=" + lithiumWeight +
                ", mixFrequency=" + mixFrequency +
                ", mixDate=" + mixDate +
                ", mixRequirements='" + mixRequirements + '\'' +
                ", mixDetection='" + mixDetection + '\'' +
                ", presinteringPlan='" + presinteringPlan + '\'' +
                ", presinteringParameter='" + presinteringParameter + '\'' +
                ", presinteringRequirements='" + presinteringRequirements + '\'' +
                ", presinteringDetection='" + presinteringDetection + '\'' +
                ", compactor=" + compactor +
                ", auditor=" + auditor +
                ", executor=" + executor +
                ", qc=" + qc +
                ", compileTime=" + compileTime +
                ", state=" + state +
                '}';
    }
}
