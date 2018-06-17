package com.hnu.mes.repository;

import com.hnu.mes.domain.BowlAbcount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 22:02
 */
public interface BowlAbcountRepository extends JpaRepository<BowlAbcount,Integer> {
    /**
     * 通过生产批号模糊查询
     * @param batchNumber
     * @param pageable
     * @return
     */
    public Page<BowlAbcount> findByBatchNumberLike(String batchNumber, Pageable pageable);
}
