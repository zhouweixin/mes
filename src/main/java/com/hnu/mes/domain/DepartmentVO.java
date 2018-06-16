package com.hnu.mes.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 14:22 2018/6/16
 * @Modified By:
 */
@Entity
@Table(name = "basicinfo_department")
public class DepartmentVO {
    /**
     * 编码
     */
    @Id
    @NotBlank(message = "部门编码不能为空")
    private String code;
    /**
     * 名称
     */
    @NotBlank(message = "部门名称不能为空")
    private String name;

    @Transient
    private List<User> users;

    /**
     * 信息
     */
    private String info;

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
