package com.hnu.mes.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.*;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 11:21
 */
@Entity
@Table(name = "release_jobs")
@EntityListeners(AuditingEntityListener.class)
public class Jobs {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 岗位名称
     */
    private String name;

    /**
     * 编制人
     */
    @ManyToOne
    @JoinColumn(name = "compiler_code",referencedColumnName = "code")
    private User compilerCode;

    /**
     * 编制时间
     */
    @CreatedDate
    @LastModifiedDate
    private Date compileTime;

    @OneToMany(targetEntity = JobsHandover.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "jobs_code", referencedColumnName = "code")
    private List<JobsHandover> JobsHandover = new ArrayList<>();

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCompilerCode() {
        return compilerCode;
    }

    public void setCompilerCode(User compilerCode) {
        this.compilerCode = compilerCode;
    }

    public Date getCompileTime() {
        return compileTime;
    }

    public void setCompileTime(Date compileTime) {
        this.compileTime = compileTime;
    }

    public List<com.hnu.mes.domain.JobsHandover> getJobsHandover() {
        return JobsHandover;
    }

    public void setJobsHandover(List<com.hnu.mes.domain.JobsHandover> jobsHandover) {
        JobsHandover = jobsHandover;
    }
}
