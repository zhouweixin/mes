package com.hnu.mes.domain;

import javax.persistence.*;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 巡检信息表
 *
 * @author chenpingxiao
 *
 */
@Entity
@Table(name = "eqmanage_tally")
public class Tally {
    /**
     * 编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    /**
     * 设备编码
     */
    @ManyToOne(targetEntity = Equipment.class)
    @JoinColumn(name = "equipment_code", referencedColumnName = "code")
    private Equipment equipment;

    /**
     * 点检时间
     */
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    @ManyToOne(targetEntity = Guide.class)
    @JoinColumn(name = "guide_code", referencedColumnName = "code")
    private Guide guide;

    // 序号
    private Integer num;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "inspector_code", referencedColumnName = "code")
    private User inspector;

    // 点检状态:0未点检;1合格;2不合格
    private Integer inspectorStatus;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "verification_code", referencedColumnName = "code")
    private User verification;

    private Integer verificationStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date verificationTime;

    @ManyToOne(targetEntity = Abnormal.class)
    @JoinColumn(name = "abnormal_code", referencedColumnName = "code")
    private Abnormal abnormal;

    @ManyToOne(targetEntity = TallyTask.class)
    @JoinColumn(name = "tally_task_code", referencedColumnName = "code")
    private TallyTask tallyTask;

    public Tally() {
    }

    public Tally(TallyTask tallyTask) {
        if(tallyTask != null){
            // 设备
            Equipment equipment = tallyTask.getEquipment();
            this.equipment = equipment;
            if(equipment != null){
                // 点检人
                this.inspector = equipment.getUser();
                if(this.inspector != null){
                    this.inspector.setRoles(null);
                }
            }

            // 指导书
            this.guide = tallyTask.getGuide();
            if (tallyTask.getGuide() != null) {
                // 序号
                this.num = tallyTask.getGuide().getNum();
            }
        }

        // 点检时间
        this.time = new Date();

        // 点检任务
        this.tallyTask = tallyTask;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public User getInspector() {
        return inspector;
    }

    public void setInspector(User inspector) {
        this.inspector = inspector;
    }

    public Integer getInspectorStatus() {
        return inspectorStatus;
    }

    public void setInspectorStatus(Integer inspectorStatus) {
        this.inspectorStatus = inspectorStatus;
    }

    public User getVerification() {
        return verification;
    }

    public void setVerification(User verification) {
        this.verification = verification;
    }

    public Integer getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(Integer verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public Date getVerificationTime() {
        return verificationTime;
    }

    public void setVerificationTime(Date verificationTime) {
        this.verificationTime = verificationTime;
    }

    public Abnormal getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(Abnormal abnormal) {
        this.abnormal = abnormal;
    }

    public TallyTask getTallyTask() {
        return tallyTask;
    }

    public void setTallyTask(TallyTask tallyTask) {
        this.tallyTask = tallyTask;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }
}
