package com.hnu.mes.repository;

import com.hnu.mes.domain.Jobs;
import com.hnu.mes.domain.JobsHandover;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 11:49
 */
public interface JobsHandoverRepository extends JpaRepository<JobsHandover,Integer> {

 //   @Query(value = "SELECT SUM(s.tag_points) FROM hackathon.stackoverflow_tags s", nativeQuery = true)
    public Page<JobsHandover> findByJobsCode(Jobs jobs, Pageable pageable);
}
