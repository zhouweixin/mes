package com.hnu.mes.service;

import com.hnu.mes.domain.*;
import com.hnu.mes.repository.*;
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
 * @Date: 2018/6/24 11:58
 */
@Service
public class JobsHandoverService {
    @Autowired
    private JobsHandoverRepository jobsHandoverRepository;

    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HandoverTypeRepository handoverTypeRepository;

    /**
     * 新增/更新
     * @param jobsHandover
     * @return
     */
    public JobsHandover save(JobsHandover jobsHandover){
        return jobsHandoverRepository.save(jobsHandover);
    }

    /**
     * 批量删除
     * @param jobsHandover
     */
    public void deleteInBatch(Collection<JobsHandover> jobsHandover) {
        jobsHandoverRepository.deleteInBatch(jobsHandover);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<JobsHandover> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            JobsHandover.class.getDeclaredField(sortFieldName);
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
        return jobsHandoverRepository.findAll(pageable);
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
    public Page<JobsHandover> findByJobsCodeByPage(Integer jobsCode,Integer page, Integer size, String sortFieldName, Integer asc){
        // 判断排序字段名是否存在
        try {
            JobsHandover.class.getDeclaredField(sortFieldName);
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

        Jobs jobs = jobsRepository.findOne(jobsCode);

        Pageable pageable = new PageRequest(page, size, sort);
        return jobsHandoverRepository.findByHeaderCode_JobsCode(jobs,pageable);
    }

    /**
     * 通过岗位编号和交班人查询
     * @param jobsCode
     * @param shifterCode
     * @return
     */
    public List<JobsHandover> findByJobsCodeAndShifterCode(Integer jobsCode,String shifterCode){
        Jobs jobs = jobsRepository.findOne(jobsCode);

        User user = userRepository.findOne(shifterCode);

        return jobsHandoverRepository.findByHeaderCode_JobsCodeAndHeaderCode_ShifterCode(jobs,user);
    }

    /**
     * 通过交接类型查询
     * @param handoverTypeCode
     * @return
     */
    public List<JobsHandover> findByHandoverType(Integer handoverTypeCode){
        HandoverType handoverType = handoverTypeRepository.findOne(handoverTypeCode);

        return jobsHandoverRepository.findByHandoverType(handoverType);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        jobsHandoverRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public JobsHandover findByCode(Integer code){
        return jobsHandoverRepository.findOne(code);
    }

}
