package com.hnu.mes.service;

import com.hnu.mes.domain.AppUpdate;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.repository.AppUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 21:11 2018/6/7
 * @Modified By:
 */
@Service
public class AppUpdateService {
    @Autowired
    private AppUpdateRepository appUpdateRepository;

    /**
     * 更新
     *
     * @param appUpdate
     */
    public void update(AppUpdate appUpdate){
        if(appUpdate != null || appUpdate.getId() == null || appUpdateRepository.findOne(appUpdate.getId()) == null){
            throw new MesException(EnumException.UPDATE_FAILED_NOT_EXIST);
        }

        appUpdateRepository.save(appUpdate);
    }

    /**
     * 新增
     *
     * @param appUpdate
     * @return
     */
    public AppUpdate save(AppUpdate appUpdate) {

        if(appUpdateRepository.findOne(appUpdate.getId()) != null){
            throw new MesException(EnumException.CODE_DUPLICATE);
        }

        return appUpdateRepository.save(appUpdate);
    }

    /**
     * 通过主键查询
     *
     * @param id
     * @return
     */
    public AppUpdate findOne(int id){
        return appUpdateRepository.findOne(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<AppUpdate> findAll(){
        return appUpdateRepository.findAll();
    }
}
