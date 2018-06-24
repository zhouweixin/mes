package com.hnu.mes.domain;

import javax.persistence.*;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 10:37
 */
@Entity
@Table(name = "basicinfo_handover_state")
public class HandoverState {
    /**
     * 主键ID，自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    /**
     * 名称
     */
    private String name;

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

    @Override
    public String toString() {
        return "HandoverState{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
