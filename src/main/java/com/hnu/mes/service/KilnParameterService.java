package com.hnu.mes.service;

import com.hnu.mes.domain.KilnParameter;
import com.hnu.mes.repository.KilnParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: WaveLee
 * @Date: 2018/6/15 20:33
 */
@Service
public class KilnParameterService {
    @Autowired
    KilnParameterRepository kilnParameterRepository;


    /**
     * 新增/更新
     * @param kilnParameter
     * @return
     */
    public KilnParameter save(KilnParameter kilnParameter){
        return kilnParameterRepository.save(kilnParameter);
    }

    /**
     * 批量删除
     * @param kilnParameter
     */
    public void deleteInBatch(Collection<KilnParameter> kilnParameter) {
        kilnParameterRepository.deleteInBatch(kilnParameter);
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<KilnParameter> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            KilnParameter.class.getDeclaredField(sortFieldName);
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
        return kilnParameterRepository.findAll(pageable);
    }

    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        kilnParameterRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public KilnParameter findByCode(Integer code){
        return kilnParameterRepository.findOne(code);
    }

}
