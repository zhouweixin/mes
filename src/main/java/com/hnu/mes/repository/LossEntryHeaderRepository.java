package com.hnu.mes.repository;

import com.hnu.mes.domain.LossEntry;
import com.hnu.mes.domain.LossEntryHeader;
import com.hnu.mes.domain.Page;
import com.hnu.mes.domain.RawType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 20:38 2018/5/30
 * @Modified By:
 */
@Repository
public interface LossEntryHeaderRepository extends JpaRepository<LossEntryHeader, Long>{
    /**
     * 通过物料类型和审核状态查询
     *
     * @param rawType
     * @param auditStatus
     * @return
     */
    public LossEntryHeader findFirstByRawTypeAndAuditStatus(RawType rawType, Integer auditStatus);
}
