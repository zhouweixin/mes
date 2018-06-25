package com.hnu.mes.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 11:31
 */
@Entity
@Table(name = "release_handover_header")
public class HandoverHeader {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 岗位名称
     */
    @ManyToOne
    @JoinColumn(name = "jobs_code",referencedColumnName = "code")
    private Jobs jobsCode;

    /**
     * 交接日期
     */
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date handoverDate;

    /**
     * 当班班次
     */
    @ManyToOne
    @JoinColumn(name = "duty_code",referencedColumnName = "code")
    private Duty dutyCode;

    /**
     * 交班人
     */
    @ManyToOne
    @JoinColumn(name = "shifter_code",referencedColumnName = "code")
    private User shifterCode;

    /**
     * 接班人
     */
    @ManyToOne
    @JoinColumn(name = "successor_code",referencedColumnName = "code")
    private User successorCode;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Jobs getJobsCode() {
        return jobsCode;
    }

    public void setJobsCode(Jobs jobsCode) {
        this.jobsCode = jobsCode;
    }

    public Date getHandoverDate() {
        return handoverDate;
    }

    public void setHandoverDate(Date handoverDate) {
        this.handoverDate = handoverDate;
    }

    public Duty getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(Duty dutyCode) {
        this.dutyCode = dutyCode;
    }

    public User getShifterCode() {
        return shifterCode;
    }

    public void setShifterCode(User shifterCode) {
        this.shifterCode = shifterCode;
    }

    public User getSuccessorCode() {
        return successorCode;
    }

    public void setSuccessorCode(User successorCode) {
        this.successorCode = successorCode;
    }

    @Override
    public String toString() {
        return "HandoverHeader{" +
                "code=" + code +
                ", jobsCode=" + jobsCode +
                ", handoverDate=" + handoverDate +
                ", dutyCode=" + dutyCode +
                ", shifterCode=" + shifterCode +
                ", successorCode=" + successorCode +
                '}';
    }
}
