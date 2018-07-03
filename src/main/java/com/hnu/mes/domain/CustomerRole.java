package com.hnu.mes.domain;

import javax.persistence.*;

/**
 * Created by lanyage on 2018/3/17.
 */
@Entity
@Table(name = "permission_customer_role")
@IdClass(CustomerRolePrimaryKey.class)
public class CustomerRole {

    @Id
    private String customerCode;
    @Id
    private int roleCode;

    public CustomerRole() {
    }

    public CustomerRole(String customerCode, int roleCode) {
        this.customerCode = customerCode;
        this.roleCode = roleCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }
}
