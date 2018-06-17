package com.hnu.mes.service;

import com.hnu.mes.domain.BowlSampling;
import com.hnu.mes.repository.BowlSamplingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 20:55
 */
@Service
public class BowlSamplingService {
    @Autowired
    private BowlSamplingRepository bowlSamplingRepository;

    /**
     * 新增/更新
     * @param bowlSampling
     * @return
     */
    public BowlSampling save(BowlSampling bowlSampling){
        return bowlSamplingRepository.save(bowlSampling);
    }

    /**
     * 批量删除
     * @param bowlSampling
     */
    public void deleteInBatch(Collection<BowlSampling> bowlSampling) {
        bowlSamplingRepository.deleteInBatch(bowlSampling);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<BowlSampling> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            BowlSampling.class.getDeclaredField(sortFieldName);
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
        return bowlSamplingRepository.findAll(pageable);
    }

    /**
     * 通过装钵机号模糊查询-分页
     * @param bowlCode
     * @param page
     * @param size
     * @param sortFielName
     * @param asc
     * @return
     */
    public Page<BowlSampling> findByBowlCodeLike(String bowlCode , Integer page , Integer size , String sortFielName ,
                                              Integer asc) {
        // 判断排序字段名是否存在
        try {
            BowlSampling.class.getDeclaredField(sortFielName);
        } catch (Exception e) {
            // 如果不存在就设置为bowlCode
            sortFielName = "bowlCode";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFielName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFielName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return bowlSamplingRepository.findByBowlCodeLike("%" + bowlCode + "%", pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        bowlSamplingRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public BowlSampling findByCode(Integer code){
        return bowlSamplingRepository.findOne(code);
    }

}
