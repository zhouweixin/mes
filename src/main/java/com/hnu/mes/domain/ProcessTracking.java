package com.hnu.mes.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @Author: WaveLee
 * @Date: 2018/6/19 22:44
 */
@Entity
@Table(name = "release_process_tracking")
public class ProcessTracking {
    /**
     * 编码，主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 产品类型
     */
    @ManyToOne
    @JoinColumn(name = "goods_code",referencedColumnName = "code")
    private Goods goodsCode;

    /**
     * 预混物料编号
     */
    private String premixedCode;

    /**
     * 预混日期
     */
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date premixedDate;

    /**
     * 混料机编号
     */
    private String mixerNumber;

    /**
     * 预烧物料编号
     */
    private String presinteringCode;

    /**
     * 预烧日期
     */
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date presinteringDate;

    /**
     * 烧结炉号
     */
    private String sinteringFurnace;

    /**
     * 粉碎物料编号
     */
    private String crushingCode;

    /**
     * 粉碎日期
     */
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date crushingDate;

    /**
     * 粉碎机编号
     */
    private String millNumber;

    /**
     * 预混操作人员
     */
    @ManyToMany
    @JoinTable(name = "release_process_tracking_premixed_operator",
            joinColumns =  @JoinColumn(name = "premixed_operatorpt_id",referencedColumnName = "code") ,
            inverseJoinColumns = @JoinColumn(name = "premixed_operator_id",referencedColumnName = "code") )
    private Set<User> premixedOperator;

    /**
     * 预烧装料人员
     */
    @ManyToMany
    @JoinTable(name = "release_process_tracking_presintering_inoperator",
            joinColumns =  @JoinColumn(name = "presintering_inoperatorpt_id",referencedColumnName = "code") ,
            inverseJoinColumns = @JoinColumn(name = "presintering_inoperator_id",referencedColumnName = "code") )
    private Set<User> presinteringInoperator;

    /**
     * 预烧倒料人员
     */
    @ManyToMany
    @JoinTable(name = "release_process_tracking_presintering_outoperator",
            joinColumns = @JoinColumn(name = "presintering_outoperatorpt_id") ,
            inverseJoinColumns = @JoinColumn(name = "presintering_outoperator_id") )
    private Set<User> presinteringOutoperator;

    /**
     * 粉碎操作人员
     */
    @ManyToMany
    @JoinTable(name = "release_process_tracking_crushing_operator",
            joinColumns = @JoinColumn(name = "crushing_operatorpt_id") ,
            inverseJoinColumns = @JoinColumn(name = "crushing_operator_id") )
    private Set<User> crushingOperator;

    /**
     * 备注
     */
    private String note;

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

    public Goods getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(Goods goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getPremixedCode() {
        return premixedCode;
    }

    public void setPremixedCode(String premixedCode) {
        this.premixedCode = premixedCode;
    }

    public Date getPremixedDate() {
        return premixedDate;
    }

    public void setPremixedDate(Date premixedDate) {
        this.premixedDate = premixedDate;
    }

    public String getMixerNumber() {
        return mixerNumber;
    }

    public void setMixerNumber(String mixerNumber) {
        this.mixerNumber = mixerNumber;
    }

    public String getPresinteringCode() {
        return presinteringCode;
    }

    public void setPresinteringCode(String presinteringCode) {
        this.presinteringCode = presinteringCode;
    }

    public Date getPresinteringDate() {
        return presinteringDate;
    }

    public void setPresinteringDate(Date presinteringDate) {
        this.presinteringDate = presinteringDate;
    }

    public String getSinteringFurnace() {
        return sinteringFurnace;
    }

    public void setSinteringFurnace(String sinteringFurnace) {
        this.sinteringFurnace = sinteringFurnace;
    }

    public String getCrushingCode() {
        return crushingCode;
    }

    public void setCrushingCode(String crushingCode) {
        this.crushingCode = crushingCode;
    }

    public Date getCrushingDate() {
        return crushingDate;
    }

    public void setCrushingDate(Date crushingDate) {
        this.crushingDate = crushingDate;
    }

    public String getMillNumber() {
        return millNumber;
    }

    public void setMillNumber(String millNumber) {
        this.millNumber = millNumber;
    }

    public Set<User> getPremixedOperator() {
        return premixedOperator;
    }

    public void setPremixedOperator(Set<User> premixedOperator) {
        this.premixedOperator = premixedOperator;
    }

    public Set<User> getPresinteringInoperator() {
        return presinteringInoperator;
    }

    public void setPresinteringInoperator(Set<User> presinteringInoperator) {
        this.presinteringInoperator = presinteringInoperator;
    }

    public Set<User> getPresinteringOutoperator() {
        return presinteringOutoperator;
    }

    public void setPresinteringOutoperator(Set<User> presinteringOutoperator) {
        this.presinteringOutoperator = presinteringOutoperator;
    }

    public Set<User> getCrushingOperator() {
        return crushingOperator;
    }

    public void setCrushingOperator(Set<User> crushingOperator) {
        this.crushingOperator = crushingOperator;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ProcessTracking{" +
                "code=" + code +
                ", goodsCode=" + goodsCode +
                ", premixedCode='" + premixedCode + '\'' +
                ", premixedDate=" + premixedDate +
                ", mixerNumber='" + mixerNumber + '\'' +
                ", presinteringCode='" + presinteringCode + '\'' +
                ", presinteringDate=" + presinteringDate +
                ", sinteringFurnace='" + sinteringFurnace + '\'' +
                ", crushingCode='" + crushingCode + '\'' +
                ", crushingDate=" + crushingDate +
                ", millNumber='" + millNumber + '\'' +
                ", premixedOperator=" + premixedOperator +
                ", presinteringInoperator=" + presinteringInoperator +
                ", presinteringOutoperator=" + presinteringOutoperator +
                ", crushingOperator=" + crushingOperator +
                ", note='" + note + '\'' +
                ", state=" + state +
                '}';
    }
}
