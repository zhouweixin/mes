package com.hnu.mes.service;

import com.hnu.mes.domain.PresinteringRecord;
import com.hnu.mes.repository.PresinteringRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 17:40
 */
@Service
public class PresinteringRecordService {
    @Autowired
    PresinteringRecordRepository presinteringRecordRepository;

    /**
     * 新增/更新
     * @param presinteringRecord
     * @return
     */
    public PresinteringRecord save(PresinteringRecord presinteringRecord){
        return presinteringRecordRepository.save(presinteringRecord);
    }

    /**
     * 批量删除
     * @param presinteringRecord
     */
    public void deleteInBatch(Collection<PresinteringRecord> presinteringRecord) {
        presinteringRecordRepository.deleteInBatch(presinteringRecord);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<PresinteringRecord> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            PresinteringRecord.class.getDeclaredField(sortFieldName);
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
        return presinteringRecordRepository.findAll(pageable);
    }

    /**
     * 通过批号模糊查询-分页
     * @param batchNumber
     * @param page
     * @param size
     * @param sortFielName
     * @param asc
     * @return
     */
    public Page<PresinteringRecord> findByBatchNumberLike(String batchNumber , Integer page , Integer size , String sortFielName ,
                                                    Integer asc) {
        // 判断排序字段名是否存在
        try {
            PresinteringRecord.class.getDeclaredField(sortFielName);
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
        return presinteringRecordRepository.findByBatchNumberLike("%" + batchNumber + "%", pageable);
    }

    /**
     * 通过窑炉编号和生产批号查询-分页
     */
    public Page<PresinteringRecord> findByKilnCodeAndBatchNumberByPage(String kilnCode,String batchNumber,Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            PresinteringRecord.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 如果不存在就设置为kilnOrder
            sortFieldName = "kilnOrder";
        }
        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return presinteringRecordRepository.findByKilnCodeAndBatchNumber(kilnCode, batchNumber,pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        presinteringRecordRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public PresinteringRecord findByCode(Integer code){
        return presinteringRecordRepository.findOne(code);
    }

}
