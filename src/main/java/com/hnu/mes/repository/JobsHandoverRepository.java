package com.hnu.mes.repository;

import com.hnu.mes.domain.HandoverType;
import com.hnu.mes.domain.Jobs;
import com.hnu.mes.domain.JobsHandover;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 11:49
 */
public interface JobsHandoverRepository extends JpaRepository<JobsHandover,Integer> {

    /**
     * 通过交接类型查询
     * @param handoverType
     * @return
     */
    public List<JobsHandover> findByHandoverType_Code(Integer handoverType);

    /**
     * 通过岗位查询
     * @param jobs
     * @return
     */
    public List<JobsHandover> findByJobsCode_Code(Integer jobs);
}
