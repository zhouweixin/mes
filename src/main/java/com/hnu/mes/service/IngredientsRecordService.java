package com.hnu.mes.service;

import com.hnu.mes.domain.IngredientsRecord;
import com.hnu.mes.repository.IngredientsRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 16:36
 */
@Service
public class IngredientsRecordService {
    @Autowired
    IngredientsRecordRepository ingredientsRecordRepository;


    /**
     * 新增/更新
     * @param ingredientsRecord
     * @return
     */
    public IngredientsRecord save(IngredientsRecord ingredientsRecord){
        return ingredientsRecordRepository.save(ingredientsRecord);
    }

    /**
     * 批量删除
     * @param ingredientsRecord
     */
    public void deleteInBatch(Collection<IngredientsRecord> ingredientsRecord) {
        ingredientsRecordRepository.deleteInBatch(ingredientsRecord);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<IngredientsRecord> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            IngredientsRecord.class.getDeclaredField(sortFieldName);
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
        return ingredientsRecordRepository.findAll(pageable);
    }

    /**
     * 通过窑炉编号模糊查询-分页
     * @param batchNumber
     * @param page
     * @param size
     * @param sortFielName
     * @param asc
     * @return
     */
    public Page<IngredientsRecord> findByBatchNumberLike(String batchNumber , Integer page , Integer size , String sortFielName ,
                                              Integer asc) {
        // 判断排序字段名是否存在
        try {
            IngredientsRecord.class.getDeclaredField(sortFielName);
        } catch (Exception e) {
            // 如果不存在就设置为batchNumber
            sortFielName = "batchNumber";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFielName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFielName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return ingredientsRecordRepository.findByBatchNumberLike("%" + batchNumber + "%", pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        ingredientsRecordRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public IngredientsRecord findByCode(Integer code){
        return ingredientsRecordRepository.findOne(code);
    }


}
