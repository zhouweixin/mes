package com.hnu.mes.controller;

import com.hnu.mes.domain.AppUpdate;
import com.hnu.mes.domain.Result;
import com.hnu.mes.service.AppUpdateService;
import com.hnu.mes.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 21:11 2018/6/7
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/appUpdate")
public class AppUpdateController {

    @Autowired
    private AppUpdateService appUpdateService;

    /**
     * 新增
     *
     * @param appUpdate
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<AppUpdate> add(AppUpdate appUpdate){
        return ResultUtil.success(appUpdateService.save(appUpdate));
    }

    /**
     * 更新
     *
     * @param appUpdate
     * @return
     */
    @RequestMapping(value = "/update")
    public Result<AppUpdate> update(AppUpdate appUpdate){
        appUpdateService.update(appUpdate);
        return ResultUtil.success();
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/getById")
    public Result<AppUpdate> getById(int id){
        return ResultUtil.success(appUpdateService.findOne(id));
    }

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping(value = "/getAll")
    public Result<List<AppUpdate>> getAll(){
        return ResultUtil.success(appUpdateService.findAll());
    }
}
