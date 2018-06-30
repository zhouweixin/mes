package com.hnu.mes.repository;

import com.hnu.mes.domain.PresinteringRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 17:36
 */
public interface PresinteringRecordRepository extends JpaRepository<PresinteringRecord,Integer> {
    /**
     * 通过批号模糊查询-分页
     */
    public Page<PresinteringRecord> findByBatchNumberLike(String batchNumber, Pageable pageable);

    /**
     * 通过窑炉编号和生产批号查询
     */
    public Page<PresinteringRecord> findByKilnCodeAndBatchNumber(String kilnOrder,String batchNumber,Pageable pageable);
}
