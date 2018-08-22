package com.hnu.mes.service;

import com.hnu.mes.domain.ByproductCount;
import com.hnu.mes.repository.ByproductCountRepository;
import com.hnu.mes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 9:07
 */
@Service
public class ByproductCountService {
    @Autowired
    ByproductCountRepository byproductCountRepository;

    /**
     * 新增/更新
     * @param byproductCount
     * @return
     */
    public ByproductCount save(ByproductCount byproductCount){
     /*   HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String recorderCode = (String) request.getSession().getAttribute("userId");
        byproductCount.setRecorderCode(userRepository.findOne(recorderCode));//取session中的值 */
        return byproductCountRepository.save(byproductCount);
    }

    /**
     * 批量删除
     * @param byproductCount
     */
    public void deleteInBatch(Collection<ByproductCount> byproductCount) {
        byproductCountRepository.deleteInBatch(byproductCount);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<ByproductCount> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            ByproductCount.class.getDeclaredField(sortFieldName);
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
        return byproductCountRepository.findAll(pageable);
    }

    /**
     * 通过生产批号模糊查询-分页
     * @param batchNumber
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<ByproductCount> findByBatchNumberLike(String batchNumber , Integer page , Integer size , String sortFieldName ,
                                                   Integer asc) {
        // 判断排序字段名是否存在
        try {
            ByproductCount.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 如果不存在就设置为batchNumber
            sortFieldName = "batchNumber";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return byproductCountRepository.findByBatchNumberLike("%" + batchNumber + "%", pageable);
    }

    /**
     * 通过副产品编号查询
     * @param byproductCode
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<ByproductCount> findByByproductCode_Code(Integer byproductCode , Integer page , Integer size , String sortFieldName ,
                                                      Integer asc) {
        // 判断排序字段名是否存在
        try {
            ByproductCount.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 如果不存在就设置为byproductCode
            sortFieldName = "byproductCode";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return byproductCountRepository.findByByproductCode_Code(byproductCode, pageable);
    }

    /**
     * 通过副产品类型和生产年月查询-分页-按日期升序排序
     * @param byproductCode
     * @param yearMonth
     * @return
     */
    public List<ByproductCount> findByByproductCodeAndYearAndMonth(Integer byproductCode, String yearMonth ) {
        return byproductCountRepository.findByByproductCodeAndAndDateLike(byproductCode,yearMonth+ "%");

    }

    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        byproductCountRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public ByproductCount findByCode(Integer code){
        return byproductCountRepository.findOne(code);
    }

}
