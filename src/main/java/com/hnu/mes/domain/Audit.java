package com.hnu.mes.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: WaveLee
 * @Date: 2018/6/29 14:15
 */
@Entity
@Table(name = "release_audit")
@EntityListeners(AuditingEntityListener.class)
public class Audit {
    /**
     * 主键code
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 电子秤编号
     */
    @ManyToOne
    @JoinColumn(name = "equipment_code",referencedColumnName = "code")
    private Equipment equipmentCode;

    /**
     * 班次编码
     */
    @ManyToOne
    @JoinColumn(name = "duty_code",referencedColumnName = "code")
    private Duty dutyCode;

    /**
     * 左上值
     */
    @Column(precision = 2)
    private Double leftUp;

    /**
     * 右上值
     */
    @Column(precision = 2)
    private Double rightUp;

    /**
     * 中值
     */
    @Column(precision = 2)
    private Double center;

    /**
     * 左下值
     */
    @Column(precision = 2)
    private Double leftDown;

    /**
     * 右下值
     */
    @Column(precision = 2)
    private Double rightDown;

    /**
     * 判定结果 0不合格/1合格
     */
    private Integer judgment;

    /**
     * 核称人
     */
    @ManyToOne
    @JoinColumn(name = "auditor_code",referencedColumnName = "code")
    private User auditorCode;

    /**
     * 核称时间
     */
    @CreatedDate
    @LastModifiedDate
    private Date auditTime;

    /**
     * 确认状态 0未确认/1确认
     */
    private Integer confirm;

    /**
     * 确认人
     */
    @ManyToOne
    @JoinColumn(name = "confirmor_code",referencedColumnName = "code")
    private User confirmorCode;

    /**
     * 确认时间
     */
    @CreatedDate
    @LastModifiedDate
    private Date confirmTime;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Equipment getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(Equipment equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public Duty getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(Duty dutyCode) {
        this.dutyCode = dutyCode;
    }

    public Double getLeftUp() {
        return leftUp;
    }

    public void setLeftUp(Double leftUp) {
        this.leftUp = leftUp;
    }

    public Double getRightUp() {
        return rightUp;
    }

    public void setRightUp(Double rightUp) {
        this.rightUp = rightUp;
    }

    public Double getCenter() {
        return center;
    }

    public void setCenter(Double center) {
        this.center = center;
    }

    public Double getLeftDown() {
        return leftDown;
    }

    public void setLeftDown(Double leftDown) {
        this.leftDown = leftDown;
    }

    public Double getRightDown() {
        return rightDown;
    }

    public void setRightDown(Double rightDown) {
        this.rightDown = rightDown;
    }

    public Integer getJudgment() {
        return judgment;
    }

    public void setJudgment(Integer judgment) {
        this.judgment = judgment;
    }

    public User getAuditorCode() {
        return auditorCode;
    }

    public void setAuditorCode(User auditorCode) {
        this.auditorCode = auditorCode;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getConfirm() {
        return confirm;
    }

    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

    public User getConfirmorCode() {
        return confirmorCode;
    }

    public void setConfirmorCode(User confirmorCode) {
        this.confirmorCode = confirmorCode;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "code=" + code +
                ", equipmentCode=" + equipmentCode +
                ", dutyCode=" + dutyCode +
                ", leftUp=" + leftUp +
                ", rightUp=" + rightUp +
                ", center=" + center +
                ", leftDown=" + leftDown +
                ", rightDown=" + rightDown +
                ", judgment=" + judgment +
                ", auditorCode=" + auditorCode +
                ", auditTime=" + auditTime +
                ", confirm=" + confirm +
                ", confirmorCode=" + confirmorCode +
                ", confirmTime=" + confirmTime +
                '}';
    }
}
