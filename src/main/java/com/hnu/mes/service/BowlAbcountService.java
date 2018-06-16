package com.hnu.mes.service;

import com.hnu.mes.domain.BowlAbcount;
import com.hnu.mes.repository.BowlAbcountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 22:03
 */
@Service
public class BowlAbcountService {
    @Autowired
    BowlAbcountRepository bowlAbcountRepository;

    /**
     * 新增/更新
     * @param bowlAbcount
     * @return
     */
    public BowlAbcount save(BowlAbcount bowlAbcount){
        return bowlAbcountRepository.save(bowlAbcount);
    }

    /**
     * 批量删除
     * @param bowlAbcount
     */
    public void deleteInBatch(Collection<BowlAbcount> bowlAbcount) {
        bowlAbcountRepository.deleteInBatch(bowlAbcount);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<BowlAbcount> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            BowlAbcount.class.getDeclaredField(sortFieldName);
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
        return bowlAbcountRepository.findAll(pageable);
    }

    /**
     * 通过生产批号模糊查询-分页
     * @param batchNumber
     * @param page
     * @param size
     * @param sortFielName
     * @param asc
     * @return
     */
    public Page<BowlAbcount> findByBatchNumberLike(String batchNumber , Integer page , Integer size , String sortFielName ,
                                                         Integer asc) {
        // 判断排序字段名是否存在
        try {
            BowlAbcount.class.getDeclaredField(sortFielName);
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
        return bowlAbcountRepository.findByBatchNumberLike("%" + batchNumber + "%", pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        bowlAbcountRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public BowlAbcount findByCode(Integer code){
        return bowlAbcountRepository.findOne(code);
    }

}
