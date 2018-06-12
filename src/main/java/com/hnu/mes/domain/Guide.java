package com.hnu.mes.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 指导书信息表
 *
 * @author chenpingxiao
 *
 */
@Entity
@Table(name = "eqmanage_guide")
public class Guide {
    /**
     * 档案编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    /**
     * 名称
     */
    private String name;

    /**
     * 序号
     */
    private Integer num;

    /**
     * 内容
     */
    private String content;

    /**
     * 标准
     */
    private String standard;

    /**
     * 周期编码
     */
    @ManyToOne(targetEntity = Cycle.class)
    @JoinColumn(name = "cyclecode", referencedColumnName = "code")
    private Cycle cycleCode;

    /**
     * 指导书头部
     */
    @ManyToOne(targetEntity = GuideHeader.class)
    @JoinColumn(name = "guide_header_code", referencedColumnName = "code")
    private GuideHeader guideHeader;

    /**
     * 图片
     */
    private Long imageCode;

    public Integer getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Cycle getCycleCode() {
        return cycleCode;
    }

    public void setCycleCode(Cycle cycleCode) {
        this.cycleCode = cycleCode;
    }

    @JsonIgnore
    public GuideHeader getGuideHeader() {
        return guideHeader;
    }

    public void setGuideHeader(GuideHeader guideHeader) {
        this.guideHeader = guideHeader;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getImageCode() {
        return imageCode;
    }

    public void setImageCode(Long imageCode) {
        this.imageCode = imageCode;
    }
}

