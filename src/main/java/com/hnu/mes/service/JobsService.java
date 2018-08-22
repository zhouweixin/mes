package com.hnu.mes.service;

import com.hnu.mes.domain.Jobs;
import com.hnu.mes.repository.JobsRepository;
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
 * @Date: 2018/6/24 11:56
 */
@Service
public class JobsService {
    @Autowired
    private JobsRepository jobsRepository;

    /**
     * 新增
     * @param jobs
     * @return
     */
    public Jobs add(Jobs jobs){
        return jobsRepository.save(jobs);
    }

    /**
     * 更新
     * @param jobs
     * @return
     */
    public Jobs update(Jobs jobs){
        jobsRepository.delete(jobs.getCode());
        return jobsRepository.save(jobs);
    }

    /**
     * 批量删除
     * @param jobs
     */
    public void deleteInBatch(Collection<Jobs> jobs) {
        jobsRepository.deleteInBatch(jobs);
    }

    /**
     * 查询所有
     */
    public List<Jobs> findAll(){
        return jobsRepository.findAll();
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<Jobs> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            Jobs.class.getDeclaredField(sortFieldName);
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
        return jobsRepository.findAll(pageable);
    }

    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        jobsRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public Jobs findByCode(Integer code){
        Jobs jobs = jobsRepository.findOne(code);
        if(jobs.getJobsHandover() != null && jobs.getJobsHandover().size() > 1){
            jobs.getJobsHandover().sort((o1, o2)->{
                return o1.getCode() - o2.getCode();
            });
        }

        return jobs;
    }

}
