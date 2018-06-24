package com.hnu.mes.repository;

import com.hnu.mes.domain.Byproduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/21 19:08
 */
public interface ByproductRepository extends JpaRepository<Byproduct,Integer> {
    /**
     * 通过副产品名称模糊查询-分页
     * @param name
     * @param pageable
     * @return
     */
    public Page<Byproduct> findByNameLike(String name, Pageable pageable);
}
