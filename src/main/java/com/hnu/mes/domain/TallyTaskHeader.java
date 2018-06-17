package com.hnu.mes.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhouweixin
 * @Description: 点检任务表头
 * @Date: Created in 21:52 2018/6/16
 * @Modified By:
 */
@Entity
@Table(name = "eqmanage_tally_task_header")
public class TallyTaskHeader {
    // 主键：自增长
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    // 创建时间
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 指导书头部
    @ManyToOne(targetEntity = GuideHeader.class)
    @JoinColumn(name = "guide_header_code", referencedColumnName = "code")
    private GuideHeader guideHeader;

    // 任务书
    @OneToMany(targetEntity = TallyTask.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "tally_task_header_code", referencedColumnName = "code")
    private List<TallyTask> tallyTasks = new ArrayList<>();

    // 完成时间
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;

    // 状态：0未点检；1已点检; 2已失效
    private Integer status = 0;

    // 点检人
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_code", referencedColumnName = "code")
    private User user;

    @ManyToOne(targetEntity = Equipment.class)
    @JoinColumn(name = "equipment_code", referencedColumnName = "code")
    private Equipment equipment;

    public TallyTaskHeader() {
    }

    public TallyTaskHeader(GuideHeader guideHeader) {
        this.createTime = new Date();
        this.guideHeader = guideHeader;
        this.equipment = guideHeader.getEquipment();

        if(this.equipment != null){
            this.user = this.equipment.getUser();
        }
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public GuideHeader getGuideHeader() {
        return guideHeader;
    }

    public void setGuideHeader(GuideHeader guideHeader) {
        this.guideHeader = guideHeader;
    }

    public List<TallyTask> getTallyTasks() {
        return tallyTasks;
    }

    public void setTallyTasks(List<TallyTask> tallyTasks) {
        this.tallyTasks = tallyTasks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
}
