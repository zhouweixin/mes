package com.hnu.mes.repository;

import com.hnu.mes.domain.KilnOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/15 17:26
 */
public interface KilnOrderRepository extends JpaRepository<KilnOrder,Integer> {
    /**
     * 通过窑炉编号模糊查询-分页
     * @param kilnCode
     * @param pageable
     * @return
     */
    public Page<KilnOrder> findByKilnCodeLike(String kilnCode, Pageable pageable);
}
