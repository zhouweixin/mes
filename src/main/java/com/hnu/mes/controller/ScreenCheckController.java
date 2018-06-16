package com.hnu.mes.controller;

import com.hnu.mes.domain.Result;
import com.hnu.mes.domain.ScreenCheck;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.ScreenCheckService;
import com.hnu.mes.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;

/**
 * @Author: WaveLee
 * @Date: 2018/6/16 18:39
 */
@RestController
@RequestMapping(value = "/screenCheck")
public class ScreenCheckController {
    @Autowired
    ScreenCheckService screenCheckService;

    /**
     * 新增
     * @param screenCheck
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<ScreenCheck> add(@Valid ScreenCheck screenCheck, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(screenCheckService.save(screenCheck));
    }

    @RequestMapping(value = "/update")
    public Result<ScreenCheck> update(@Valid ScreenCheck screenCheck, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        //判断是否重复
        if (screenCheckService.findByCode(screenCheck.getCode()) == null) {
            return ResultUtil.error(new MesException(EnumException.UPDATE_FAILED_NOT_EXIST));
        }
        return ResultUtil.success(screenCheckService.save(screenCheck));
    }

    /**
     * 批量删除
     * @param screenCheck
     * @return
     */
    @RequestMapping(value = "/deleteByIdBatch")
    public Result<Object> deleteByIdBatch(@RequestBody Collection<ScreenCheck> screenCheck) {
        screenCheckService.deleteInBatch(screenCheck);
        return ResultUtil.success();
    }

    /**
     * 查询所有-分页
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    @RequestMapping(value = "/getAllByPage")
    public Result<Page<ScreenCheck>> getAllByPage(@RequestParam(value = "page" , defaultValue = "0" ) Integer page,
                                                  @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                  @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                                  @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(screenCheckService.findAllByPage(page , size , sortFieldName ,asc));
    }

    /**
     * 通过code删除
     * @param code
     * @return
     */
    @RequestMapping(value = "/deleteByCode")
    public Result<Object> deleteById(Integer code) {
        screenCheckService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    @RequestMapping(value = "/getById")
    public Result<ScreenCheck> findByCode(Integer code) {
        return ResultUtil.success(screenCheckService.findByCode(code));
    }
}
