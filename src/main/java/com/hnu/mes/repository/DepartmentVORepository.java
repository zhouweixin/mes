package com.hnu.mes.repository;

import com.hnu.mes.domain.DepartmentVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 14:23 2018/6/16
 * @Modified By:
 */
@Repository
public interface DepartmentVORepository extends JpaRepository<DepartmentVO, String> {
}
