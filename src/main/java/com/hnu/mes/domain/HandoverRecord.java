package com.hnu.mes.domain;

import javax.persistence.*;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 11:40
 */
@Entity
@Table(name = "release_handover_record")
public class HandoverRecord {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 记录表头id
     */
    @ManyToOne
    @JoinColumn(name = "header_code",referencedColumnName = "code")
    private HandoverHeader headerCode;

    /**
     * 记录内容id
     */
    @ManyToOne
    @JoinColumn(name = "content_code",referencedColumnName = "code")
    private HandoverContent contentCode;

    /**
     * 交接状态值id
     */
    @ManyToOne
    @JoinColumn(name = "state_code",referencedColumnName = "code")
    private HandoverState stateCode;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HandoverHeader getHeaderCode() {
        return headerCode;
    }

    public void setHeaderCode(HandoverHeader headerCode) {
        this.headerCode = headerCode;
    }

    public HandoverContent getContentCode() {
        return contentCode;
    }

    public void setContentCode(HandoverContent contentCode) {
        this.contentCode = contentCode;
    }

    public HandoverState getStateCode() {
        return stateCode;
    }

    public void setStateCode(HandoverState stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public String toString() {
        return "HandoverRecord{" +
                "code=" + code +
                ", headerCode=" + headerCode +
                ", contentCode=" + contentCode +
                ", stateCode=" + stateCode +
                '}';
    }
}
