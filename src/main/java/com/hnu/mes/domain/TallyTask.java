package com.hnu.mes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 21:56 2018/6/16
 * @Modified By:
 */
@Entity
@Table(name = "eqmanage_tally_task")
public class TallyTask {
    // 主键：自增长
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    // 点检任务
    @JsonIgnore
    @ManyToOne(targetEntity = TallyTaskHeader.class)
    @JoinColumn(name = "tally_task_header_code", referencedColumnName = "code")
    private TallyTaskHeader tallyTaskHeader;

    // 指导书
    @ManyToOne(targetEntity = Guide.class)
    @JoinColumn(name = "guide_code", referencedColumnName = "code")
    private Guide guide;

    // 设备
    @ManyToOne(targetEntity = Equipment.class)
    @JoinColumn(name = "equipment_code", referencedColumnName = "code")
    private Equipment equipment;

    // 创建时间
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 完成时间
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;

    // 状态：0未点检；1已点检; 2已失效
    private Integer status = 0;

    public TallyTask() {
    }

    public TallyTask(Guide guide, Equipment equipment) {
        this.guide = guide;
        this.createTime = new Date();
        this.equipment = equipment;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public TallyTaskHeader getTallyTaskHeader() {
        return tallyTaskHeader;
    }

    public void setTallyTaskHeader(TallyTaskHeader tallyTaskHeader) {
        this.tallyTaskHeader = tallyTaskHeader;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
