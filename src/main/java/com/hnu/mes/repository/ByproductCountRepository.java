package com.hnu.mes.repository;

import com.hnu.mes.domain.ByproductCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 9:06
 */
public interface ByproductCountRepository extends JpaRepository<ByproductCount,Integer> {
    /**
     * 通过生产批号模糊查询
     * @param batchNumber
     * @param pageable
     * @return
     */
    public Page<ByproductCount> findByBatchNumberLike(String batchNumber, Pageable pageable);
}
