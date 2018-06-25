package com.hnu.mes.repository;

import com.hnu.mes.domain.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 11:48
 */
public interface JobsRepository extends JpaRepository<Jobs,Integer> {
}
