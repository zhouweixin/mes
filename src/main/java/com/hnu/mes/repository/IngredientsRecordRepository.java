package com.hnu.mes.repository;

import com.hnu.mes.domain.IngredientsRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 16:31
 */
public interface IngredientsRecordRepository extends JpaRepository<IngredientsRecord,Integer> {
    /**
     * 通过生产批号模糊查询
     * @param batchNumber
     * @param pageable
     * @return
     */
    public Page<IngredientsRecord> findByBatchNumberLike(String batchNumber, Pageable pageable);
}
