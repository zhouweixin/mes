package com.hnu.mes.domain;

import javax.persistence.*;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 10:39
 */
@Entity
@Table(name = "basicinfo_handover_statetype")
public class HandoverStateType {
    /**
     * 主键ID，自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 交接状态ID1
     */
    @ManyToOne
    @JoinColumn(name = "handover_state1",referencedColumnName = "code")
    private HandoverState handoverState1;

    /**
     * 交接状态ID2
     */
    @ManyToOne
    @JoinColumn(name = "handover_state2",referencedColumnName = "code")
    private HandoverState handoverState2;

    /**
     * 交接状态ID3
     */
    @ManyToOne
    @JoinColumn(name = "handover_state3",referencedColumnName = "code")
    private HandoverState handoverState3;

    /**
     * 交接状态ID4
     */
    @ManyToOne
    @JoinColumn(name = "handover_state4",referencedColumnName = "code")
    private HandoverState handoverState4;

    /**
     * 交接状态ID5
     */
    @ManyToOne
    @JoinColumn(name = "handover_state5",referencedColumnName = "code")
    private HandoverState handoverState5;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HandoverState getHandoverState1() {
        return handoverState1;
    }

    public void setHandoverState1(HandoverState handoverState1) {
        this.handoverState1 = handoverState1;
    }

    public HandoverState getHandoverState2() {
        return handoverState2;
    }

    public void setHandoverState2(HandoverState handoverState2) {
        this.handoverState2 = handoverState2;
    }

    public HandoverState getHandoverState3() {
        return handoverState3;
    }

    public void setHandoverState3(HandoverState handoverState3) {
        this.handoverState3 = handoverState3;
    }

    public HandoverState getHandoverState4() {
        return handoverState4;
    }

    public void setHandoverState4(HandoverState handoverState4) {
        this.handoverState4 = handoverState4;
    }

    public HandoverState getHandoverState5() {
        return handoverState5;
    }

    public void setHandoverState5(HandoverState handoverState5) {
        this.handoverState5 = handoverState5;
    }

    @Override
    public String toString() {
        return "HandoverStateType{" +
                "code=" + code +
                ", handoverState1=" + handoverState1 +
                ", handoverState2=" + handoverState2 +
                ", handoverState3=" + handoverState3 +
                ", handoverState4=" + handoverState4 +
                ", handoverState5=" + handoverState5 +
                '}';
    }
}
