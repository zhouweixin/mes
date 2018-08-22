package com.hnu.mes.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

/**
 * @Author: WaveLee
 * @Date: 2018/6/15 17:02
 */
@Entity
@Table(name = "release_kiln_order")
public class KilnOrder {

    /**
     * 编码
     * 主键，非空
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 窑炉编号
     */
    private String kilnCode;

    /**
     * 强排风
     */
    private String exhaust;

    /**
     * 通风类型
     */
    private String exhaustType;

    /**
     * 通气总量
     */
    private String exhaustWeight;

    /**
     * 上部通气
     */
    private String exhaustTop;

    /**
     * 底部通气
     */
    private String exhaustBottom;

    /**
     * 备注
     */
    private String note;

    /**
     * 生效日期
     */
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date effectiveDate;

    /**
     * 编制人
     */
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "compactor_code", referencedColumnName = "code")
    private User compactor;

    /**
     * 编制时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date compileTime;

    /**
     * 状态标志
     */
    private boolean state;

    @OneToMany(targetEntity = KilnParameter.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "kiln_order_code", referencedColumnName = "code")
    private List<KilnParameter> KilnParameters = new ArrayList<>();

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getKilnCode() {
        return kilnCode;
    }

    public void setKilnCode(String kilnCode) {
        this.kilnCode = kilnCode;
    }

    public String getExhaust() {
        return exhaust;
    }

    public void setExhaust(String exhaust) {
        this.exhaust = exhaust;
    }

    public String getExhaustType() {
        return exhaustType;
    }

    public void setExhaustType(String exhaustType) {
        this.exhaustType = exhaustType;
    }

    public String getExhaustWeight() {
        return exhaustWeight;
    }

    public void setExhaustWeight(String exhaustWeight) {
        this.exhaustWeight = exhaustWeight;
    }

    public String getExhaustTop() {
        return exhaustTop;
    }

    public void setExhaustTop(String exhaustTop) {
        this.exhaustTop = exhaustTop;
    }

    public String getExhaustBottom() {
        return exhaustBottom;
    }

    public void setExhaustBottom(String exhaustBottom) {
        this.exhaustBottom = exhaustBottom;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public User getCompactor() {
        return compactor;
    }

    public void setCompactor(User compactor) {
        this.compactor = compactor;
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

    public List<KilnParameter> getKilnParameters() {
        return KilnParameters;
    }

    public void setKilnParameters(List<KilnParameter> kilnParameters) {
        KilnParameters = kilnParameters;
    }
}
