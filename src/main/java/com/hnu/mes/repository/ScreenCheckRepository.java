package com.hnu.mes.repository;

import com.hnu.mes.domain.ScreenCheck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 18:32
 */
public interface ScreenCheckRepository extends JpaRepository<ScreenCheck,Integer> {
    /**
     * 通过筛网编号查询-分页
     * @param shakerCode
     * @param pageable
     * @return
     */
    public Page<ScreenCheck> findByShakerCodeLike(String shakerCode, Pageable pageable);
}
