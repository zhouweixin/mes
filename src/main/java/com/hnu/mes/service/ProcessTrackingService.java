package com.hnu.mes.service;

import com.hnu.mes.domain.ProcessTracking;
import com.hnu.mes.repository.ProcessTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: WaveLee
 * @Date: 2018/6/20 14:55
 */
@Service
public class ProcessTrackingService {
    @Autowired
    private ProcessTrackingRepository processTrackingRepository;


    /**
     * 新增/更新
     * @param processTracking
     * @return
     */
    public ProcessTracking save(ProcessTracking processTracking){
        return processTrackingRepository.save(processTracking);
    }

    /**
     * 批量删除
     * @param processTracking
     */
    public void deleteInBatch(Collection<ProcessTracking> processTracking) {
        processTrackingRepository.deleteInBatch(processTracking);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<ProcessTracking> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            ProcessTracking.class.getDeclaredField(sortFieldName);
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
        return processTrackingRepository.findAll(pageable);
    }

    /**
     * 通过预烧物料编号模糊查询-分页
     * @param premixedCode
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<ProcessTracking> findByPremixedCodeLike(String premixedCode , Integer page , Integer size , String sortFieldName ,
                                                    Integer asc) {
        // 判断排序字段名是否存在
        try {
            ProcessTracking.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 如果不存在就设置为premixedCode
            sortFieldName = "premixedCode";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return processTrackingRepository.findByPremixedCodeLike("%" + premixedCode + "%", pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        processTrackingRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public ProcessTracking findByCode(Integer code){
        return processTrackingRepository.findOne(code);
    }

}
