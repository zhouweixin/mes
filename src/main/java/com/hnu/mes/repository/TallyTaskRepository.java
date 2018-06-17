package com.hnu.mes.repository;

import com.hnu.mes.domain.Guide;
import com.hnu.mes.domain.TallyTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 21:59 2018/6/16
 * @Modified By:
 */
public interface TallyTaskRepository extends JpaRepository<TallyTask, Long> {
    /**
     * 通过指导书查询和状态查询任务
     *
     * @param guide
     * @param status
     * @return
     */
    public TallyTask findFirstByGuideAndStatus(Guide guide, Integer status);

    /**
     * 通过编码更新状态
     *
     * @param status
     * @param date
     * @param code
     */
    @Modifying
    @Query(value = "update TallyTask t set t.status=?1, t.finishTime=?2 where t.code=?3")
    public void updateStatusByCode(int status, Date date, Long code);
}
