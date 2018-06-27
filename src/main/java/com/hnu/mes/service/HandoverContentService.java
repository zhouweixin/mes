package com.hnu.mes.service;

import com.hnu.mes.domain.HandoverContent;
import com.hnu.mes.repository.HandoverContentRepository;
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
 * @Date: 2018/6/24 10:55
 */
@Service
public class HandoverContentService {
    @Autowired
    private HandoverContentRepository handoverContentRepository;


    /**
     * 新增/更新
     * @param handoverContent
     * @return
     */
    public HandoverContent save(HandoverContent handoverContent){
        return handoverContentRepository.save(handoverContent);
    }

    /**
     * 批量删除
     * @param handoverContent
     */
    public void deleteInBatch(Collection<HandoverContent> handoverContent) {
        handoverContentRepository.deleteInBatch(handoverContent);
    }

    /**
     * 查询所有
     */
    public List<HandoverContent> findAll(){
        return handoverContentRepository.findAll();
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<HandoverContent> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            HandoverContent.class.getDeclaredField(sortFieldName);
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
        return handoverContentRepository.findAll(pageable);
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
    public Page<HandoverContent> findByNameLike(String name , Integer page , Integer size , String sortFieldName ,
                                          Integer asc) {
        // 判断排序字段名是否存在
        try {
            HandoverContent.class.getDeclaredField(sortFieldName);
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
        return handoverContentRepository.findByNameLike("%" + name + "%", pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        handoverContentRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public HandoverContent findByCode(Integer code){
        return handoverContentRepository.findOne(code);
    }

}
