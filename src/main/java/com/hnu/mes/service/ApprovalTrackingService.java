package com.hnu.mes.service;

import com.hnu.mes.domain.ApprovalTracking;
import com.hnu.mes.repository.ApprovalTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: WaveLee
 * @Date: 2018/6/20 20:41
 */
@Service
public class ApprovalTrackingService {
    @Autowired
    ApprovalTrackingRepository approvalTrackingRepository;

    /**
     * 新增/更新
     * @param approvalTracking
     * @return
     */
    public ApprovalTracking save(ApprovalTracking approvalTracking){
        return approvalTrackingRepository.save(approvalTracking);
    }

    /**
     * 批量删除
     * @param approvalTracking
     */
    public void deleteInBatch(Collection<ApprovalTracking> approvalTracking) {
        approvalTrackingRepository.deleteInBatch(approvalTracking);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<ApprovalTracking> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            ApprovalTracking.class.getDeclaredField(sortFieldName);
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
        return approvalTrackingRepository.findAll(pageable);
    }

    /**
     * 通过物料打包编号模糊查询-分页
     * @param packagingCode
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<ApprovalTracking> findByPackagingCodeLike(String packagingCode , Integer page , Integer size , String sortFieldName ,
                                                    Integer asc) {
        // 判断排序字段名是否存在
        try {
            ApprovalTracking.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 如果不存在就设置为packagingCode
            sortFieldName = "packagingCode";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return approvalTrackingRepository.findByPackagingCodeLike("%" + packagingCode + "%", pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        approvalTrackingRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public ApprovalTracking findByCode(Integer code){
        return approvalTrackingRepository.findOne(code);
    }

}
