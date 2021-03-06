package com.hnu.mes.domain;

import javax.persistence.*;

/**
 * Created by lanyage on 2018/3/15.
 */
@Entity
@Table(name = "basicinfo_supplier")
public class Supplier {
    /**
     * 编号
     */
    @Id
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 地点
     */
    private String address;
    /**
     * 类型
     */
    @ManyToOne(targetEntity = SupplierType.class)
    @JoinColumn(name = "type_code", referencedColumnName = "code")
    private SupplierType supplierType;
    /**
     * 联系人电话
     */
    private String contact;
    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 信用代号
     */
    private String creditCode;

    public Supplier() {
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

    public SupplierType getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(SupplierType supplierType) {
        this.supplierType = supplierType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", supplierType=" + supplierType +
                ", contact='" + contact + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", creditCode='" + creditCode + '\'' +
                '}';
    }
}
