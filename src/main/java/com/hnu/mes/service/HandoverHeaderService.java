package com.hnu.mes.service;

import com.hnu.mes.domain.HandoverHeader;
import com.hnu.mes.repository.HandoverHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 12:00
 */
@Service
public class HandoverHeaderService {
    @Autowired
    private HandoverHeaderRepository handoverHeaderRepository;

    /**
     * 新增/更新
     * @param handoverHeader
     * @return
     */
    public HandoverHeader save(HandoverHeader handoverHeader){
        return handoverHeaderRepository.save(handoverHeader);
    }

    /**
     * 批量删除
     * @param handoverHeader
     */
    public void deleteInBatch(Collection<HandoverHeader> handoverHeader) {
        handoverHeaderRepository.deleteInBatch(handoverHeader);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<HandoverHeader> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            HandoverHeader.class.getDeclaredField(sortFieldName);
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
        return handoverHeaderRepository.findAll(pageable);
    }

    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        handoverHeaderRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public HandoverHeader findByCode(Integer code){
        return handoverHeaderRepository.findOne(code);
    }

}
