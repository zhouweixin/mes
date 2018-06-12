package com.hnu.mes.repository;

import com.hnu.mes.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 18:06 2018/6/6
 * @Modified By:
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
