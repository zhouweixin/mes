package com.hnu.mes.service;

import com.hnu.mes.domain.ProductOrder;
import com.hnu.mes.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: WaveLee
 * @Date: 2018/6/14 22:05
 */
@Service
public class ProductOrderService {
    @Autowired
    private ProductOrderRepository productOrderRepository;

    /**
     * 新增/更新
     * @param productOrder
     * @return
     */
    public ProductOrder save(ProductOrder productOrder){
        return productOrderRepository.save(productOrder);
    }

    /**
     * 批量删除
     * @param productOrder
     */
    public void deleteInBatch(Collection<ProductOrder> productOrder) {
        productOrderRepository.deleteInBatch(productOrder);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<ProductOrder> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            ProductOrder.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 如果不存在就设置为code
            sortFieldName = "code";
        }
        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return productOrderRepository.findAll(pageable);
    }

    /**
     * 通过批号模糊查询-分页
     * @param batchNumber
     * @param page
     * @param size
     * @param sortFielName
     * @param asc
     * @return
     */
    public Page<ProductOrder> findByBatchNumberLike(String batchNumber , Integer page , Integer size , String sortFielName ,
                                              Integer asc) {
        // 判断排序字段名是否存在
        try {
            ProductOrder.class.getDeclaredField(sortFielName);
        } catch (Exception e) {
            // 如果不存在就设置为batchNumber
            sortFielName = "batchNumber";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFielName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFielName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return productOrderRepository.findByBatchNumberLike("%" + batchNumber + "%", pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        productOrderRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public ProductOrder findByCode(Integer code){
        return productOrderRepository.findOne(code);
    }

}
