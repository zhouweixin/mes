package com.hnu.mes.domain;

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
     * 记录表内容id
     */
    @ManyToOne
    @JoinColumn(name = "record_code",referencedColumnName = "code")
    private HandoverRecord recordCode;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    public HandoverRecord getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(HandoverRecord recordCode) {
        this.recordCode = recordCode;
    }

    @Override
    public String toString() {
        return "JobsHandover{" +
                "code=" + code +
                ", handoverType=" + handoverType +
                ", handoverContent=" + handoverContent +
                ", handoverStateType=" + handoverStateType +
                ", recordCode=" + recordCode +
                '}';
    }
}
