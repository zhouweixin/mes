package com.hnu.mes.service;

import com.hnu.mes.domain.KilnOrder;
import com.hnu.mes.domain.KilnParameter;
import com.hnu.mes.repository.KilnOrderRepository;
import com.hnu.mes.repository.KilnParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @Author: WaveLee
 * @Date: 2018/6/15 20:29
 */
@Service
public class KilnOrderService {
    @Autowired
    KilnOrderRepository kilnOrderRepository;

    /**
     * 新增
     * @param kilnOrder
     * @return
     */
    public KilnOrder add(KilnOrder kilnOrder){
        return kilnOrderRepository.save(kilnOrder);
    }

    /**
     * 更新
     * @param kilnOrder
     * @return
     */
    public KilnOrder update(KilnOrder kilnOrder){
        kilnOrderRepository.delete(kilnOrder.getCode());
        return kilnOrderRepository.save(kilnOrder);
    }
    /**
     * 批量删除
     * @param kilnOrder
     */
    public void deleteInBatch(Collection<KilnOrder> kilnOrder) {
        kilnOrderRepository.deleteInBatch(kilnOrder);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<KilnOrder> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            KilnOrder.class.getDeclaredField(sortFieldName);
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
        return kilnOrderRepository.findAll(pageable);
    }

    /**
     * 通过窑炉编号模糊查询-分页
     * @param kilnCode
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<KilnOrder> findByKilnCodeLike(String kilnCode , Integer page , Integer size , String sortFieldName ,
                                                   Integer asc) {
        // 判断排序字段名是否存在
        try {
            KilnOrder.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 如果不存在就设置为kilnCode
            sortFieldName = "kilnCode";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return kilnOrderRepository.findByKilnCodeLike("%" + kilnCode + "%", pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        kilnOrderRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public KilnOrder findByCode(Integer code){
        return kilnOrderRepository.findOne(code);
    }


}
