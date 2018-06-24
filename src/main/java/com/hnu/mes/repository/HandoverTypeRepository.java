package com.hnu.mes.repository;

import com.hnu.mes.domain.HandoverType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 10:47
 */
public interface HandoverTypeRepository extends JpaRepository<HandoverType,Integer> {
    /**
     * 通过名称模糊查询-分页
     * @param name
     * @param pageable
     * @return
     */
    public Page<HandoverType> findByNameLike(String name, Pageable pageable);
}
