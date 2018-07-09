package com.hnu.mes.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 10:57 2018/5/9
 * @Modified By:
 */
@Entity
@Table(name = "available_product")
public class AvailableProduct {
    /**
     * 批号
     */
    @Id
    private String batchNumber;
    /**
     * 当前总量
     */
    private Double currentActualMaterials;
    /**
     * 可用量
     */
    private Double currentAvailableMaterials;
    /**
     * 单位
     */
    private String materialsUnit;
    /**
     * 状态
     */
    private Integer judgeCode;

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Double getCurrentActualMaterials() {
        return currentActualMaterials;
    }

    public void setCurrentActualMaterials(Double currentActualMaterials) {
        this.currentActualMaterials = currentActualMaterials;
    }

    public Double getCurrentAvailableMaterials() {
        return currentAvailableMaterials;
    }

    public void setCurrentAvailableMaterials(Double currentAvailableMaterials) {
        this.currentAvailableMaterials = currentAvailableMaterials;
    }

    public String getMaterialsUnit() {
        return materialsUnit;
    }

    public void setMaterialsUnit(String materialsUnit) {
        this.materialsUnit = materialsUnit;
    }

    public Integer getJudgeCode() {
        return judgeCode;
    }

    public void setJudgeCode(Integer judgeCode) {
        this.judgeCode = judgeCode;
    }

    @Override
    public String toString() {
        return "AvailableProduct{" +
                "batchNumber='" + batchNumber + '\'' +
                ", currentActualMaterials=" + currentActualMaterials +
                ", currentAvailableMaterials=" + currentAvailableMaterials +
                ", materialsUnit='" + materialsUnit + '\'' +
                ", judgeCode=" + judgeCode +
                '}';
    }
}
