package com.hnu.mes.domain;

import javax.persistence.*;

/**
 * @Author: zhouweixin
 * @Description: 电子秤
 * @Date: Created in 16:04 2018/6/30
 * @Modified By:
 */
@Entity
@Table(name = "basicinfo_electronic_balance")
public class ElectronicBalance {
    @Id
    private String code;

    private String name;

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
}
