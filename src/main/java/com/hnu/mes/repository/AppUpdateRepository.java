package com.hnu.mes.repository;

import com.hnu.mes.domain.AppUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 21:10 2018/6/7
 * @Modified By:
 */
@Repository
public interface AppUpdateRepository extends JpaRepository<AppUpdate, Integer> {
}
