package com.hnu.mes.service;

import com.hnu.mes.domain.HandoverType;
import com.hnu.mes.repository.HandoverTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 10:52
 */
@Service
public class HandoverTypeService {
    @Autowired
    private HandoverTypeRepository handoverTypeRepository;

    /**
     * 新增/更新
     * @param handoverType
     * @return
     */
    public HandoverType save(HandoverType handoverType){
        return handoverTypeRepository.save(handoverType);
    }

    /**
     * 批量删除
     * @param handoverType
     */
    public void deleteInBatch(Collection<HandoverType> handoverType) {
        handoverTypeRepository.deleteInBatch(handoverType);
    }

    /**
     * 查询所有
     */
    public List<HandoverType> findAll(){
        return handoverTypeRepository.findAll();
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<HandoverType> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            HandoverType.class.getDeclaredField(sortFieldName);
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
        return handoverTypeRepository.findAll(pageable);
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
    public Page<HandoverType> findByNameLike(String name , Integer page , Integer size , String sortFieldName ,
                                          Integer asc) {
        // 判断排序字段名是否存在
        try {
            HandoverType.class.getDeclaredField(sortFieldName);
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
        return handoverTypeRepository.findByNameLike("%" + name + "%", pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        handoverTypeRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public HandoverType findByCode(Integer code){
        return handoverTypeRepository.findOne(code);
    }

}
