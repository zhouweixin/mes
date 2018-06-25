package com.hnu.mes.repository;

import com.hnu.mes.domain.ApprovalTracking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/20 20:38
 */
public interface ApprovalTrackingRepository extends JpaRepository<ApprovalTracking,Integer> {
    /**
     * 通过物料打包编号模糊查询-分页
     * @param packagingCode
     * @param pageable
     * @return
     */
    public Page<ApprovalTracking> findByPackagingCodeLike(String packagingCode, Pageable pageable);
}
