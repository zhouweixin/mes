package com.hnu.mes.service;

import java.util.List;

import com.hnu.mes.domain.AppCheck;
import com.hnu.mes.domain.AppCheck;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.hnu.mes.repository.AppCheckRepository;

import javax.transaction.Transactional;


/**
 * @author p[ngxiao
 */
@Service
public class AppCheckService {
    // 注入
    @Autowired
    private AppCheckRepository appCheckRepository;

    /**
     * 新增
     *
     * @param appCheck
     * @return
     */
    public AppCheck save(AppCheck appCheck) {
        return appCheckRepository.save(appCheck);
    }

    /**
     * 删除
     *
     * @param code
     */
    public void delete(Long code) {
        appCheckRepository.delete(code);
    }

    /**
     * 查询
     *
     * @param code
     * @return
     */
    public AppCheck findOne(Long code) {
        return appCheckRepository.findOne(code);
    }


    /**
     * 查询所有
     *
     * @return
     */
    public List<AppCheck> findAll() {
        return appCheckRepository.findAll();
    }


    /**
     * 更新时间
     *
     * @param examPerson
     * @return
     */
    @Transactional
    public Integer updateExamPersonByCode(String examPerson, String examState,String examDate,Long code) {
        return appCheckRepository.updateExamPersonByCode(examPerson,examState,examDate, code);
    }


    /**
     * 通过审核state分页查询
     *
     * @param examState
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<AppCheck> getAllByExamPersonByPage(String examState, Integer page, Integer size, String sortFieldName, Integer asc) {
        try {
            AppCheck.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            throw new MesException(EnumException.SORT_FIELD);
        }


        Sort sort = null;
        if (asc == 0) {
            //降序，desc
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            //升序，asc
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        //分页
        Pageable pageable = new PageRequest(page, size, sort);

        return appCheckRepository.findByExamState(examState, pageable);
    }

}
