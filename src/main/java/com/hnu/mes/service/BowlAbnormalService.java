package com.hnu.mes.service;

import com.hnu.mes.domain.BowlAbnormal;
import com.hnu.mes.repository.BowlAbnormalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 21:23
 */
@Service
public class BowlAbnormalService {
    @Autowired
    BowlAbnormalRepository bowlAbnormalRepository;

    /**
     * 新增/更新
     * @param bowlAbnormal
     * @return
     */
    public BowlAbnormal save(BowlAbnormal bowlAbnormal){
        return bowlAbnormalRepository.save(bowlAbnormal);
    }

    /**
     * 批量删除
     * @param bowlAbnormal
     */
    public void deleteInBatch(Collection<BowlAbnormal> bowlAbnormal) {
        bowlAbnormalRepository.deleteInBatch(bowlAbnormal);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<BowlAbnormal> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            BowlAbnormal.class.getDeclaredField(sortFieldName);
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
        return bowlAbnormalRepository.findAll(pageable);
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
    public Page<BowlAbnormal> findByBowlCodeLike(String bowlCode , Integer page , Integer size , String sortFielName ,
                                                 Integer asc) {
        // 判断排序字段名是否存在
        try {
            BowlAbnormal.class.getDeclaredField(sortFielName);
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
        return bowlAbnormalRepository.findByBowlCodeLike("%" + bowlCode + "%", pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        bowlAbnormalRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public BowlAbnormal findByCode(Integer code){
        return bowlAbnormalRepository.findOne(code);
    }

}
