package com.hnu.mes.repository;

import com.hnu.mes.domain.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hnu.mes.domain.Guide;

/**
 *
 * @author PINGXIAO
 *
 */
public interface GuideRepository extends JpaRepository<Guide, Long> {
    /**
     * 通过名称模糊查询-分页
     * @param name
     * @param pageable
     * @return
     */
    public Page<Guide> findByNameLike(String name, Pageable pageable);

    /**
     * 通过图片查询
     *
     * @param imageCode
     * @return
     */
    public Guide findFirstByImageCode(Long imageCode);
}
