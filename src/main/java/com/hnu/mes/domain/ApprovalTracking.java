package com.hnu.mes.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: WaveLee
 * @Date: 2018/6/20 15:28
 */
@Entity
@Table(name = "release_approval_tracking")
@EntityListeners(AuditingEntityListener.class)
public class ApprovalTracking {
    /**
     * 编码，主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 物料打包编号
     */
    private String packagingCode;

    /**
     * 打包重量
     */
    @Column(precision = 2)
    private Double packagingWeight;

    /**
     * 合批仓编号
     */
    private String warehouseCode;

    /**
     * 合批槽是否正常1
     */
    private boolean slotsNormal1;

    /**
     * 物料入仓日期
     */
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date warehousingDate;

    /**
     * 物料入仓总载总重
     */
    @Column(precision = 2)
    private Double warehousingWeight;

    /**
     * 合批槽是否正常2
     */
    private boolean slotsNormal2;

    /**
     * 合批物料编号
     */
    private String materialCode;

    /**
     * 物料入仓操作人员
     */
    @ManyToOne
    @JoinColumn(name = "warehousing_operator",referencedColumnName = "code")
    private User warehousingOperator;

    /**
     * 打包日期
     */
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date packagingDate;

    /**
     * 混料时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mixTime;

    /**
     * 冷水机温度
     */
    @Column(precision = 2)
    private Double chillerTemperature;

    /**
     * 包装房温度
     */
    @Column(precision = 2)
    private Double packingroomTemperature;

    /**
     * 包装房湿度
     */
    @Column(precision = 2)
    private Double packingroomHumidity;

    /**
     * 物料打包操作人员
     */
    @ManyToOne
    @JoinColumn(name = "packaging_operator",referencedColumnName = "code")
    private User packagingOperator;

    /**
     * 除铁料重量
     */
    @Column(precision = 2)
    private Double defeWeight;

    /**
     * 合批槽余料
     */
    @Column(precision = 2)
    private Double slotsLeft;

    /**
     * 筛网是否正常
     */
    private boolean screenNormal;

    /**
     * 录入时间
     */
    @CreatedDate
    private Date entryTime;

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

    public String getPackagingCode() {
        return packagingCode;
    }

    public void setPackagingCode(String packagingCode) {
        this.packagingCode = packagingCode;
    }

    public Double getPackagingWeight() {
        return packagingWeight;
    }

    public void setPackagingWeight(Double packagingWeight) {
        this.packagingWeight = packagingWeight;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public boolean isSlotsNormal1() {
        return slotsNormal1;
    }

    public void setSlotsNormal1(boolean slotsNormal1) {
        this.slotsNormal1 = slotsNormal1;
    }

    public Date getWarehousingDate() {
        return warehousingDate;
    }

    public void setWarehousingDate(Date warehousingDate) {
        this.warehousingDate = warehousingDate;
    }

    public Double getWarehousingWeight() {
        return warehousingWeight;
    }

    public void setWarehousingWeight(Double warehousingWeight) {
        this.warehousingWeight = warehousingWeight;
    }

    public boolean isSlotsNormal2() {
        return slotsNormal2;
    }

    public void setSlotsNormal2(boolean slotsNormal2) {
        this.slotsNormal2 = slotsNormal2;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public User getWarehousingOperator() {
        return warehousingOperator;
    }

    public void setWarehousingOperator(User warehousingOperator) {
        this.warehousingOperator = warehousingOperator;
    }

    public Date getPackagingDate() {
        return packagingDate;
    }

    public void setPackagingDate(Date packagingDate) {
        this.packagingDate = packagingDate;
    }

    public Date getMixTime() {
        return mixTime;
    }

    public void setMixTime(Date mixTime) {
        this.mixTime = mixTime;
    }

    public Double getChillerTemperature() {
        return chillerTemperature;
    }

    public void setChillerTemperature(Double chillerTemperature) {
        this.chillerTemperature = chillerTemperature;
    }

    public Double getPackingroomTemperature() {
        return packingroomTemperature;
    }

    public void setPackingroomTemperature(Double packingroomTemperature) {
        this.packingroomTemperature = packingroomTemperature;
    }

    public Double getPackingroomHumidity() {
        return packingroomHumidity;
    }

    public void setPackingroomHumidity(Double packingroomHumidity) {
        this.packingroomHumidity = packingroomHumidity;
    }

    public User getPackagingOperator() {
        return packagingOperator;
    }

    public void setPackagingOperator(User packagingOperator) {
        this.packagingOperator = packagingOperator;
    }

    public Double getDefeWeight() {
        return defeWeight;
    }

    public void setDefeWeight(Double defeWeight) {
        this.defeWeight = defeWeight;
    }

    public Double getSlotsLeft() {
        return slotsLeft;
    }

    public void setSlotsLeft(Double slotsLeft) {
        this.slotsLeft = slotsLeft;
    }

    public boolean isScreenNormal() {
        return screenNormal;
    }

    public void setScreenNormal(boolean screenNormal) {
        this.screenNormal = screenNormal;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ApprovalTracking{" +
                "code=" + code +
                ", packagingCode='" + packagingCode + '\'' +
                ", packagingWeight=" + packagingWeight +
                ", warehouseCode='" + warehouseCode + '\'' +
                ", slotsNormal1=" + slotsNormal1 +
                ", warehousingDate=" + warehousingDate +
                ", warehousingWeight=" + warehousingWeight +
                ", slotsNormal2=" + slotsNormal2 +
                ", materialCode='" + materialCode + '\'' +
                ", warehousingOperator=" + warehousingOperator +
                ", packagingDate=" + packagingDate +
                ", mixTime=" + mixTime +
                ", chillerTemperature=" + chillerTemperature +
                ", packingroomTemperature=" + packingroomTemperature +
                ", packingroomHumidity=" + packingroomHumidity +
                ", packagingOperator=" + packagingOperator +
                ", defeWeight=" + defeWeight +
                ", slotsLeft=" + slotsLeft +
                ", screenNormal=" + screenNormal +
                ", entryTime=" + entryTime +
                ", state=" + state +
                '}';
    }
}
