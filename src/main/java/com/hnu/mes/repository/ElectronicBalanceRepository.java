package com.hnu.mes.repository;

import com.hnu.mes.domain.ElectronicBalance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 16:07 2018/6/30
 * @Modified By:
 */
@Repository
public interface ElectronicBalanceRepository extends JpaRepository<ElectronicBalance, String> {
    /**
     * 通过名称模糊查询-分页
     * @param name
     * @param pageable
     * @return
     */
    public Page<ElectronicBalance> findByNameLike(String name, Pageable pageable);
}
