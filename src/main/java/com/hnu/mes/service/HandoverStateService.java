package com.hnu.mes.service;

import com.hnu.mes.domain.HandoverState;
import com.hnu.mes.repository.HandoverStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 10:57
 */
@Service
public class HandoverStateService {
    @Autowired
    private HandoverStateRepository handoverStateRepository;


    /**
     * 新增/更新
     * @param handoverState
     * @return
     */
    public HandoverState save(HandoverState handoverState){
        return handoverStateRepository.save(handoverState);
    }

    /**
     * 批量删除
     * @param handoverState
     */
    public void deleteInBatch(Collection<HandoverState> handoverState) {
        handoverStateRepository.deleteInBatch(handoverState);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<HandoverState> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            HandoverState.class.getDeclaredField(sortFieldName);
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
        return handoverStateRepository.findAll(pageable);
    }

    /**
     * 通过名称模糊查询-分页
     * @param name
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<HandoverState> findByNameLike(String name , Integer page , Integer size , String sortFieldName ,
                                          Integer asc) {
        // 判断排序字段名是否存在
        try {
            HandoverState.class.getDeclaredField(sortFieldName);
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
        return handoverStateRepository.findByNameLike("%" + name + "%", pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        handoverStateRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public HandoverState findByCode(Integer code){
        return handoverStateRepository.findOne(code);
    }

}
