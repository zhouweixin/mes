package com.hnu.mes.domain;

import org.apache.ibatis.annotations.Many;

import javax.persistence.*;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 11:25
 */
@Entity
@Table(name = "release_jobs_handover")
public class JobsHandover {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 岗位名称id
     */
    @ManyToOne
    @JoinColumn(name = "jobs_code",referencedColumnName = "code")
    private Jobs jobsCode;

    /**
     * 交接类型
     */
    @ManyToOne
    @JoinColumn(name = "handover_type",referencedColumnName = "code")
    private HandoverType handoverType;

    /**
     * 交接内容
     */
    @ManyToOne
    @JoinColumn(name = "handover_content",referencedColumnName = "code")
    private HandoverContent handoverContent;

    /**
     * 交接类型状态
     */
    @ManyToOne
    @JoinColumn(name = "handover_statetype",referencedColumnName = "code")
    private HandoverStateType handoverStateType;

    /**
     * 记录表头id
     */
    @ManyToOne
    @JoinColumn(name = "header_code",referencedColumnName = "code")
    private HandoverHeader headerCode;

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

    public HandoverType getHandoverType() {
        return handoverType;
    }

    public void setHandoverType(HandoverType handoverType) {
        this.handoverType = handoverType;
    }

    public HandoverContent getHandoverContent() {
        return handoverContent;
    }

    public void setHandoverContent(HandoverContent handoverContent) {
        this.handoverContent = handoverContent;
    }

    public HandoverStateType getHandoverStateType() {
        return handoverStateType;
    }

    public void setHandoverStateType(HandoverStateType handoverStateType) {
        this.handoverStateType = handoverStateType;
    }

    public HandoverHeader getHeaderCode() {
        return headerCode;
    }

    public void setHeaderCode(HandoverHeader headerCode) {
        this.headerCode = headerCode;
    }

    @Override
    public String toString() {
        return "JobsHandover{" +
                "code=" + code +
                ", jobsCode=" + jobsCode +
                ", handoverType=" + handoverType +
                ", handoverContent=" + handoverContent +
                ", handoverStateType=" + handoverStateType +
                ", headerCode=" + headerCode +
                '}';
    }
}
