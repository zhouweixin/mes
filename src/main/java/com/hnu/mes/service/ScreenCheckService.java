package com.hnu.mes.service;

import com.hnu.mes.domain.ScreenCheck;
import com.hnu.mes.repository.ScreenCheckRepository;
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
 * @Date: 2018/6/16 18:32
 */
@Service
public class ScreenCheckService {
    @Autowired
    ScreenCheckRepository screenCheckRepository;

    /**
     * 新增/更新
     * @param screenCheck
     * @return
     */
    public ScreenCheck save(ScreenCheck screenCheck){
        return screenCheckRepository.save(screenCheck);
    }

    /**
     * 批量删除
     * @param screenCheck
     */
    public void deleteInBatch(Collection<ScreenCheck> screenCheck) {
        screenCheckRepository.deleteInBatch(screenCheck);
    }

    /**
     * 查询所有
     * @return
     */
    public List<ScreenCheck> findAll(){
        return screenCheckRepository.findAll();
    }
    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<ScreenCheck> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            ScreenCheck.class.getDeclaredField(sortFieldName);
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
        return screenCheckRepository.findAll(pageable);
    }


    /**
     * 通过筛网编号查询-分页
     * @param shakerCode
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<ScreenCheck> findByShakerCodeLike(String shakerCode , Integer page , Integer size , String sortFieldName ,
                                                    Integer asc) {
        // 判断排序字段名是否存在
        try {
            ScreenCheck.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 如果不存在就设置为shakerCode
            sortFieldName = "shakerCode";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return screenCheckRepository.findByShakerCodeLike("%" + shakerCode + "%", pageable);
    }
    /**
     * 通过code删除
     * @param code
     */
    public void delete(Integer code){
        screenCheckRepository.delete(code);
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    public ScreenCheck findByCode(Integer code){
        return screenCheckRepository.findOne(code);
    }

}
