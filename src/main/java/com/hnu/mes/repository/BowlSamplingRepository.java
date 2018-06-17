package com.hnu.mes.repository;

import com.hnu.mes.domain.BowlSampling;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 20:50
 */
public interface BowlSamplingRepository extends JpaRepository<BowlSampling,Integer> {
    /**
     * 通过装钵机号模糊查询
     * @param bowlCode
     * @param pageable
     * @return
     */
    public Page<BowlSampling> findByBowlCodeLike(String bowlCode, Pageable pageable);
}
