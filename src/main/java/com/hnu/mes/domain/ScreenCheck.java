package com.hnu.mes.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 17:54
 */
@Entity
@Table(name = "release_screen_check")
public class ScreenCheck {
    /**
     * 编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 振筛编号
     */
    private String shakerCode;

    /**
     * 图片内容
     */
    private Blob picture;

    /**
     * 检查人
     */
    @ManyToOne
    @JoinColumn(name = "inspector_code",referencedColumnName = "code")
    private User inspector;

    /**
     * 检查时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inspectorTime;

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

    public String getShakerCode() {
        return shakerCode;
    }

    public void setShakerCode(String shakerCode) {
        this.shakerCode = shakerCode;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public User getInspector() {
        return inspector;
    }

    public void setInspector(User inspector) {
        this.inspector = inspector;
    }

    public Date getInspectorTime() {
        return inspectorTime;
    }

    public void setInspectorTime(Date inspectorTime) {
        this.inspectorTime = inspectorTime;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ScreenCheck{" +
                "code=" + code +
                ", shakerCode='" + shakerCode + '\'' +
                ", picture=" + picture +
                ", inspector=" + inspector +
                ", inspectorTime=" + inspectorTime +
                ", state=" + state +
                '}';
    }
}
