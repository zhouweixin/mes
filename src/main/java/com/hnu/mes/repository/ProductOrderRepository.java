package com.hnu.mes.repository;

import com.hnu.mes.domain.ProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/14 21:59
 */
public interface ProductOrderRepository extends JpaRepository<ProductOrder,Integer> {
    /**
     * 通过批号模糊查询-分页
     */
    public Page<ProductOrder> findByBatchNumberLike(String batchNumber, Pageable pageable);
}
