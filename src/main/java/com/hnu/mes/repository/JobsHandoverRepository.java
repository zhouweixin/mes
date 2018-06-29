package com.hnu.mes.repository;

import com.hnu.mes.domain.HandoverType;
import com.hnu.mes.domain.Jobs;
import com.hnu.mes.domain.JobsHandover;
import com.hnu.mes.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 11:49
 */
public interface JobsHandoverRepository extends JpaRepository<JobsHandover,Integer> {

    /**
     * 通过岗位id查询
     * @param jobs
     * @param pageable
     * @return
     */
    public Page<JobsHandover> findByRecordCode_HeaderCode_JobsCode(Jobs jobs, Pageable pageable);

    /**
     * 通过岗位id和交班人id查询
     * @param jobs
     * @param user
     * @return
     */
    public List<JobsHandover> findByRecordCode_HeaderCode_JobsCodeAndRecordCode_HeaderCode_ShifterCode(Jobs jobs,User user);

    /**
     * 通过交接类型查询
     * @param handoverType
     * @return
     */
    public List<JobsHandover> findByHandoverType(HandoverType handoverType);
}
