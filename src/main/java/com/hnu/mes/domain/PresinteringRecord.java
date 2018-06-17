package com.hnu.mes.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 17:08
 */
@Entity
@Table(name = "release_presintering_record")
public class PresinteringRecord {

    /**
     * 编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 窑炉号
     */
    private String kilnCode;

    /**
     * 烧结工艺，0预烧/1二烧
     */
    private boolean sinteringProcess;

    /**
     * 批次编号
     */
    private String batchNumber;

    /**
     * 进钵数量1
     */
    private Integer inportNumber1;

    /**
     * 进钵数量2
     */
    private Integer inportNumber2;

    /**
     * 进钵数量3
     */
    private Integer inportNumber3;

    /**
     * 进钵数量4
     */
    private Integer inportNumber4;

    /**
     * 进炉时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date infurnaceTime;

    /**
     * 预计进炉时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planTime;

    /**
     * 进炉操作人1
     */
    @ManyToOne
    @JoinColumn(name = "infurnace_operator1",referencedColumnName = "code")
    private User infurnaceOperator1;

    /**
     * 进炉操作人2
     */
    @ManyToOne
    @JoinColumn(name = "infurnace_operator2",referencedColumnName = "code")
    private User infurnaceOperator2;

    /**
     * 进炉操作人3
     */
    @ManyToOne
    @JoinColumn(name = "infurnace_operator3",referencedColumnName = "code")
    private User infurnaceOperator3;

    /**
     * 进炉操作人4
     */
    @ManyToOne
    @JoinColumn(name = "infurnace_operator4",referencedColumnName = "code")
    private User infurnaceOperator4;

    /**
     * 实际出炉时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date outfurnaceTime;

    /**
     * 倒钵数量1
     */
    private Integer outportNumber1;

    /**
     * 倒钵数量2
     */
    private Integer outportNumber2;

    /**
     * 倒钵数量3
     */
    private Integer outportNumber3;

    /**
     * 倒钵数量4
     */
    private Integer outportNumber4;

    /**
     * 使用新钵数量1
     */
    private Integer newportNumber1;

    /**
     * 使用新钵数量2
     */
    private Integer newportNumber2;

    /**
     * 使用新钵数量3
     */
    private Integer newportNumber3;

    /**
     * 使用新钵数量4
     */
    private Integer newportNumber4;

    /**
     * 废弃匣钵数量1
     */
    private Integer abaportNumber1;

    /**
     * 废弃匣钵数量2
     */
    private Integer abaportNumber2;

    /**
     * 废弃匣钵数量3
     */
    private Integer abaportNumber3;

    /**
     * 废弃匣钵数量4
     */
    private Integer abaportNumber4;

    /**
     * 出炉操作人1
     */
    @ManyToOne
    @JoinColumn(name = "outfurnace_operator1",referencedColumnName = "code")
    private User outfurnaceOperator1;


    /**
     * 出炉操作人2
     */
    @ManyToOne
    @JoinColumn(name = "outfurnace_operator2",referencedColumnName = "code")
    private User outfurnaceOperator2;

    /**
     * 出炉操作人3
     */
    @ManyToOne
    @JoinColumn(name = "outfurnace_operator3",referencedColumnName = "code")
    private User outfurnaceOperator3;

    /**
     * 出炉操作人4
     */
    @ManyToOne
    @JoinColumn(name = "outfurnace_operator4",referencedColumnName = "code")
    private User outfurnaceOperator4;

    /**
     * 主任助理确认
     */

    /**
     * 出炉操作人1
     */
    @ManyToOne
    @JoinColumn(name = "assistant_code",referencedColumnName = "code")
    private User assistant;

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

    public String getKilnCode() {
        return kilnCode;
    }

    public void setKilnCode(String kilnCode) {
        this.kilnCode = kilnCode;
    }

    public boolean isSinteringProcess() {
        return sinteringProcess;
    }

    public void setSinteringProcess(boolean sinteringProcess) {
        this.sinteringProcess = sinteringProcess;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Integer getInportNumber1() {
        return inportNumber1;
    }

    public void setInportNumber1(Integer inportNumber1) {
        this.inportNumber1 = inportNumber1;
    }

    public Integer getInportNumber2() {
        return inportNumber2;
    }

    public void setInportNumber2(Integer inportNumber2) {
        this.inportNumber2 = inportNumber2;
    }

    public Integer getInportNumber3() {
        return inportNumber3;
    }

    public void setInportNumber3(Integer inportNumber3) {
        this.inportNumber3 = inportNumber3;
    }

    public Integer getInportNumber4() {
        return inportNumber4;
    }

    public void setInportNumber4(Integer inportNumber4) {
        this.inportNumber4 = inportNumber4;
    }

    public Date getInfurnaceTime() {
        return infurnaceTime;
    }

    public void setInfurnaceTime(Date infurnaceTime) {
        this.infurnaceTime = infurnaceTime;
    }

    public Date getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Date planTime) {
        this.planTime = planTime;
    }

    public User getInfurnaceOperator1() {
        return infurnaceOperator1;
    }

    public void setInfurnaceOperator1(User infurnaceOperator1) {
        this.infurnaceOperator1 = infurnaceOperator1;
    }

    public User getInfurnaceOperator2() {
        return infurnaceOperator2;
    }

    public void setInfurnaceOperator2(User infurnaceOperator2) {
        this.infurnaceOperator2 = infurnaceOperator2;
    }

    public User getInfurnaceOperator3() {
        return infurnaceOperator3;
    }

    public void setInfurnaceOperator3(User infurnaceOperator3) {
        this.infurnaceOperator3 = infurnaceOperator3;
    }

    public User getInfurnaceOperator4() {
        return infurnaceOperator4;
    }

    public void setInfurnaceOperator4(User infurnaceOperator4) {
        this.infurnaceOperator4 = infurnaceOperator4;
    }

    public Date getOutfurnaceTime() {
        return outfurnaceTime;
    }

    public void setOutfurnaceTime(Date outfurnaceTime) {
        this.outfurnaceTime = outfurnaceTime;
    }

    public Integer getOutportNumber1() {
        return outportNumber1;
    }

    public void setOutportNumber1(Integer outportNumber1) {
        this.outportNumber1 = outportNumber1;
    }

    public Integer getOutportNumber2() {
        return outportNumber2;
    }

    public void setOutportNumber2(Integer outportNumber2) {
        this.outportNumber2 = outportNumber2;
    }

    public Integer getOutportNumber3() {
        return outportNumber3;
    }

    public void setOutportNumber3(Integer outportNumber3) {
        this.outportNumber3 = outportNumber3;
    }

    public Integer getOutportNumber4() {
        return outportNumber4;
    }

    public void setOutportNumber4(Integer outportNumber4) {
        this.outportNumber4 = outportNumber4;
    }

    public Integer getNewportNumber1() {
        return newportNumber1;
    }

    public void setNewportNumber1(Integer newportNumber1) {
        this.newportNumber1 = newportNumber1;
    }

    public Integer getNewportNumber2() {
        return newportNumber2;
    }

    public void setNewportNumber2(Integer newportNumber2) {
        this.newportNumber2 = newportNumber2;
    }

    public Integer getNewportNumber3() {
        return newportNumber3;
    }

    public void setNewportNumber3(Integer newportNumber3) {
        this.newportNumber3 = newportNumber3;
    }

    public Integer getNewportNumber4() {
        return newportNumber4;
    }

    public void setNewportNumber4(Integer newportNumber4) {
        this.newportNumber4 = newportNumber4;
    }

    public Integer getAbaportNumber1() {
        return abaportNumber1;
    }

    public void setAbaportNumber1(Integer abaportNumber1) {
        this.abaportNumber1 = abaportNumber1;
    }

    public Integer getAbaportNumber2() {
        return abaportNumber2;
    }

    public void setAbaportNumber2(Integer abaportNumber2) {
        this.abaportNumber2 = abaportNumber2;
    }

    public Integer getAbaportNumber3() {
        return abaportNumber3;
    }

    public void setAbaportNumber3(Integer abaportNumber3) {
        this.abaportNumber3 = abaportNumber3;
    }

    public Integer getAbaportNumber4() {
        return abaportNumber4;
    }

    public void setAbaportNumber4(Integer abaportNumber4) {
        this.abaportNumber4 = abaportNumber4;
    }

    public User getOutfurnaceOperator1() {
        return outfurnaceOperator1;
    }

    public void setOutfurnaceOperator1(User outfurnaceOperator1) {
        this.outfurnaceOperator1 = outfurnaceOperator1;
    }

    public User getOutfurnaceOperator2() {
        return outfurnaceOperator2;
    }

    public void setOutfurnaceOperator2(User outfurnaceOperator2) {
        this.outfurnaceOperator2 = outfurnaceOperator2;
    }

    public User getOutfurnaceOperator3() {
        return outfurnaceOperator3;
    }

    public void setOutfurnaceOperator3(User outfurnaceOperator3) {
        this.outfurnaceOperator3 = outfurnaceOperator3;
    }

    public User getOutfurnaceOperator4() {
        return outfurnaceOperator4;
    }

    public void setOutfurnaceOperator4(User outfurnaceOperator4) {
        this.outfurnaceOperator4 = outfurnaceOperator4;
    }

    public User getAssistant() {
        return assistant;
    }

    public void setAssistant(User assistant) {
        this.assistant = assistant;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "PresinteringRecord{" +
                "code=" + code +
                ", kilnCode='" + kilnCode + '\'' +
                ", sinteringProcess=" + sinteringProcess +
                ", batchNumber='" + batchNumber + '\'' +
                ", inportNumber1=" + inportNumber1 +
                ", inportNumber2=" + inportNumber2 +
                ", inportNumber3=" + inportNumber3 +
                ", inportNumber4=" + inportNumber4 +
                ", infurnaceTime=" + infurnaceTime +
                ", planTime=" + planTime +
                ", infurnaceOperator1=" + infurnaceOperator1 +
                ", infurnaceOperator2=" + infurnaceOperator2 +
                ", infurnaceOperator3=" + infurnaceOperator3 +
                ", infurnaceOperator4=" + infurnaceOperator4 +
                ", outfurnaceTime=" + outfurnaceTime +
                ", outportNumber1=" + outportNumber1 +
                ", outportNumber2=" + outportNumber2 +
                ", outportNumber3=" + outportNumber3 +
                ", outportNumber4=" + outportNumber4 +
                ", newportNumber1=" + newportNumber1 +
                ", newportNumber2=" + newportNumber2 +
                ", newportNumber3=" + newportNumber3 +
                ", newportNumber4=" + newportNumber4 +
                ", abaportNumber1=" + abaportNumber1 +
                ", abaportNumber2=" + abaportNumber2 +
                ", abaportNumber3=" + abaportNumber3 +
                ", abaportNumber4=" + abaportNumber4 +
                ", outfurnaceOperator1=" + outfurnaceOperator1 +
                ", outfurnaceOperator2=" + outfurnaceOperator2 +
                ", outfurnaceOperator3=" + outfurnaceOperator3 +
                ", outfurnaceOperator4=" + outfurnaceOperator4 +
                ", assistant=" + assistant +
                ", state=" + state +
                '}';
    }
}
