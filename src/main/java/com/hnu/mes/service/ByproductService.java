package com.hnu.mes.service;

import com.hnu.mes.domain.Byproduct;
import com.hnu.mes.repository.ByproductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 8:14
 */
@Service
public class ByproductService {
    @Autowired
    private ByproductRepository byproductRepository;

    /**
     * 新增/更新
     * @param byproduct
     * @return
     */
    public Byproduct save(Byproduct byproduct){
        return byproductRepository.save(byproduct);
    }

    /**
     * 批量删除
     * @param byproduct
     */
    public void deleteInBatch(Collection<Byproduct> byproduct) {
        byproductRepository.deleteInBatch(byproduct);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<Byproduct> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            Byproduct.class.getDeclaredField(sortFieldName);
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
        return byproductRepository.findAll(pageable);
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
    public Page<Byproduct> findByNameLike(String name , Integer page , Integer size , String sortFieldName ,
                                          Integer asc) {
        // 判断排序字段名是否存在
        try {
            Byproduct.class.getDeclaredField(sortFieldName);
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
        return byproductRepository.findByNameLike("%" + name + "%", pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        byproductRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public Byproduct findByCode(Integer code){
        return byproductRepository.findOne(code);
    }

}
