package com.hnu.mes.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;;import java.util.ArrayList;
import java.util.List;

/**
 * 部门信息表
 * 
 * @author zhouweixin
 *
 */
@Entity
@Table(name = "basicinfo_department")
public class Department {
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

	/**
	 * 信息
	 */
	private String info;

    public Department() {
    }

    public Department(String code, String name, String info) {
        this.code = code;
        this.name = name;
        this.info = info;
    }

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

    @Override
	public String toString() {
		return "Department [code=" + code + ", name=" + name + ", info=" + info + "]";
	}
}
