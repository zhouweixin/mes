package com.hnu.mes.service;

import com.hnu.mes.domain.HandoverRecord;
import com.hnu.mes.repository.HandoverRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 12:01
 */
@Service
public class HandoverRecordService {
    @Autowired
    private HandoverRecordRepository handoverRecordRepository;

    /**
     * 新增/更新
     * @param handoverRecord
     * @return
     */
    public HandoverRecord save(HandoverRecord handoverRecord){
        return handoverRecordRepository.save(handoverRecord);
    }

    /**
     * 批量删除
     * @param handoverRecord
     */
    public void deleteInBatch(Collection<HandoverRecord> handoverRecord) {
        handoverRecordRepository.deleteInBatch(handoverRecord);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<HandoverRecord> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            HandoverRecord.class.getDeclaredField(sortFieldName);
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
        return handoverRecordRepository.findAll(pageable);
    }

    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        handoverRecordRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public HandoverRecord findByCode(Integer code){
        return handoverRecordRepository.findOne(code);
    }

}
