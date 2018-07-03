package com.hnu.mes.repository;

import com.hnu.mes.domain.CustomerRole;
import com.hnu.mes.domain.CustomerRolePrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 19:47 2018/7/3
 * @Modified By:
 */
public interface CustomerRoleRepository extends JpaRepository<CustomerRole, CustomerRolePrimaryKey> {
}
