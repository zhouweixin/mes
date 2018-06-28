package com.hnu.mes.repository;

import com.hnu.mes.domain.Jobs;
import com.hnu.mes.domain.JobsHandover;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 11:49
 */
public interface JobsHandoverRepository extends JpaRepository<JobsHandover,Integer> {

    public Page<JobsHandover> findByJobsCode(Jobs jobs, Pageable pageable);
}
