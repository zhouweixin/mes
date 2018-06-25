package com.hnu.mes.repository;

import com.hnu.mes.domain.ProcessTracking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/20 14:50
 */
public interface ProcessTrackingRepository extends JpaRepository<ProcessTracking,Integer> {
    /**
     * 通过预混物料编号模糊查询-分页
     * @param premixedCode
     * @param pageable
     * @return
     */
    public Page<ProcessTracking> findByPremixedCodeLike(String premixedCode, Pageable pageable);
}
