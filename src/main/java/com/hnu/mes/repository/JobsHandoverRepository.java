package com.hnu.mes.repository;

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

    public Page<JobsHandover> findByRecordCode_HeaderCode_JobsCode(Jobs jobs, Pageable pageable);

    public List<JobsHandover> findByRecordCode_HeaderCode_JobsCodeAndRecordCode_HeaderCode_ShifterCode(Jobs jobs,User user);
}
