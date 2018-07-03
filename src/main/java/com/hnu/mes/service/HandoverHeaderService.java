package com.hnu.mes.service;

import com.hnu.mes.domain.HandoverHeader;
import com.hnu.mes.domain.Jobs;
import com.hnu.mes.domain.User;
import com.hnu.mes.repository.HandoverHeaderRepository;
import com.hnu.mes.repository.JobsRepository;
import com.hnu.mes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

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
     * 通过岗位编号查询-分页
     * @param jobsCode
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<HandoverHeader> findByJobsCodeByPage(Integer jobsCode,Integer page, Integer size, String sortFieldName, Integer asc){
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
        return handoverHeaderRepository.findByJobsCode_Code(jobsCode,pageable);
    }

    /**
     * 通过岗位编号和交班人查询
     * @param jobsCode
     * @param shifterCode
     * @return
     */
    public List<HandoverHeader> findByJobsCodeAndShifterCode(Integer jobsCode, String shifterCode){
        return handoverHeaderRepository.findByJobsCode_CodeAndShifterCode_Code(jobsCode, shifterCode);
    }

    /**
     * 通过岗位编号和交班人查询
     * @param jobsCode
     * @param successorCode
     * @return
     */
    public List<HandoverHeader> findByJobsCodeAndSuccessorCode(Integer jobsCode,String successorCode){
        return handoverHeaderRepository.findByJobsCode_CodeAndSuccessorCode_Code(jobsCode, successorCode);
    }

    /**
     * 通过岗位名称模糊和日期查询
     * @param jobsName
     * @param handoverDate
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<HandoverHeader> findByJobsNameAndHandoverDateByPage(String jobsName, Date handoverDate,Integer page, Integer size, String sortFieldName, Integer asc){
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
        return handoverHeaderRepository.findByJobsCode_NameLikeAndHandoverDate("%" + jobsName + "%",handoverDate,pageable);
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
