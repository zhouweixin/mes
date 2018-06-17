package com.hnu.mes.repository;

import com.hnu.mes.domain.GuideHeader;
import com.hnu.mes.domain.TallyTaskHeader;
import com.hnu.mes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 22:00 2018/6/16
 * @Modified By:
 */
public interface TallyTaskHeaderRepository extends JpaRepository<TallyTaskHeader, Long> {
    /**
     * 通过指导书头部查询
     *
     * @param guideHeader
     * @return
     */
    public TallyTaskHeader findFirstByGuideHeaderAndStatus(GuideHeader guideHeader, Integer status);

    /**
     * 通过编码更新状态
     *
     * @param i
     * @param code
     */
    @Modifying
    @Query(value = "update TallyTaskHeader t set t.status=?1, t.finishTime=?2 where t.code=?3")
    public void updateStatusByCode(int i, Date date, Long code);

    /**
     * 通过点检人和状态查询
     *
     * @param user
     * @param status
     * @return
     */
    public List<TallyTaskHeader> findByUserAndStatus(User user, Integer status);
}
