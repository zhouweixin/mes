package com.hnu.mes.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.apache.ibatis.annotations.Many;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 指导书信息表
 *
 * @author chenpingxiao
 *
 */
@Entity
@Table(name = "eqmanage_guide_header")
public class GuideHeader {
    /**
     * 指导书编码
     */
    @Id
    @NotBlank(message = "指导书编码不能为空")
    private String code;

    @ManyToOne(targetEntity = Equipment.class)
    @JoinColumn(name = "equipment_code", referencedColumnName = "code")
    private Equipment equipment;


    /**
     * 指导书名称
     */
    private String name;

    /**
     * 指导书编号
     */
    private String num;

    /**
     * 版次
     */
    private String edition;

    /**
     * 生效日期
     */
    private String effectivedate;

    /**
     * 编制人
     */
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "compactorcode", referencedColumnName = "code")
    private User compactorcode;

    /**
     * 审核人
     */
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "auditorcode", referencedColumnName = "code")
    private User auditorcode;


    /**
     * 批准人
     */
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "approvercode", referencedColumnName = "code")
    private User approvercode;

    /**
     * 指导书
     */
    @OneToMany(targetEntity = Guide.class, cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
    @JoinColumn(name = "guide_header_code")
    private List<Guide> guides = new ArrayList<Guide>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getEffectivedate() {
        return effectivedate;
    }

    public void setEffectivedate(String effectivedate) {
        this.effectivedate = effectivedate;
    }

    public User getCompactorcode() {
        return compactorcode;
    }

    public void setCompactorcode(User compactorcode) {
        this.compactorcode = compactorcode;
    }

    public User getAuditorcode() {
        return auditorcode;
    }

    public void setAuditorcode(User auditorcode) {
        this.auditorcode = auditorcode;
    }

    public User getApprovercode() {
        return approvercode;
    }

    public void setApprovercode(User approvercode) {
        this.approvercode = approvercode;
    }

    public List<Guide> getGuides() {
        return guides;
    }

    public void setGuides(List<Guide> guides) {
        this.guides = guides;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "GuideHeader{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", edition='" + edition + '\'' +
                ", effectivedate='" + effectivedate + '\'' +
                ", compactorcode=" + compactorcode +
                ", auditorcode=" + auditorcode +
                ", approvercode=" + approvercode +
                ", guides=" + guides +
                '}';
    }
}

