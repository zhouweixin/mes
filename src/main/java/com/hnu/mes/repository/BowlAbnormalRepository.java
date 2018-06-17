package com.hnu.mes.repository;

import com.hnu.mes.domain.BowlAbnormal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 21:22
 */
public interface BowlAbnormalRepository extends JpaRepository<BowlAbnormal,Integer> {
    /**
     * 通过装钵机号模糊查询
     * @param bowlCode
     * @param pageable
     * @return
     */
    public Page<BowlAbnormal> findByBowlCodeLike(String bowlCode, Pageable pageable);
}
