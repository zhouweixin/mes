package com.hnu.mes.controller;

import com.hnu.mes.domain.HandoverState;
import com.hnu.mes.domain.Result;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.HandoverStateService;
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
import java.util.List;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 11:04
 */
@RestController
@RequestMapping(value = "/handoverState")
public class HandoverStateController {
    @Autowired
    private HandoverStateService handoverStateService;


    /**
     * 新增
     * @param handoverState
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<HandoverState> add(@Valid HandoverState handoverState, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(handoverStateService.save(handoverState));
    }

    @RequestMapping(value = "/update")
    public Result<HandoverState> update(@Valid HandoverState handoverState, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        //判断是否重复
        if (handoverStateService.findByCode(handoverState.getCode()) == null) {
            return ResultUtil.error(new MesException(EnumException.UPDATE_FAILED_NOT_EXIST));
        }
        return ResultUtil.success(handoverStateService.save(handoverState));
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/getAll")
    public Result<List<HandoverState>> getAll(){
        return ResultUtil.success(handoverStateService.findAll());
    }

    /**
     * 批量删除
     * @param handoverState
     * @return
     */
    @RequestMapping(value = "/deleteByIdBatch")
    public Result<Object> deleteByIdBatch(@RequestBody Collection<HandoverState> handoverState) {
        handoverStateService.deleteInBatch(handoverState);
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
    public Result<Page<HandoverState>> getAllByPage(@RequestParam(value = "page" , defaultValue = "0" ) Integer page,
                                                @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                                @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(handoverStateService.findAllByPage(page , size , sortFieldName ,asc));
    }

    /**
     * 通过名称模糊查询-分页
     * @param name
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    @RequestMapping(value = "/getByNameLikeByPage")
    public Result<Page<HandoverState>> getByNameLikeByPage(@RequestParam(value = "name" , defaultValue = "") String name,
                                                       @RequestParam(value = "page" , defaultValue = "0") Integer page,
                                                       @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                       @RequestParam(value = "sortFieldName" , defaultValue = "batchNumber") String sortFieldName,
                                                       @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(handoverStateService.findByNameLike(name , page, size , sortFieldName , asc));
    }

    /**
     * 通过code删除
     * @param code
     * @return
     */
    @RequestMapping(value = "/deleteByCode")
    public Result<Object> deleteById(Integer code) {
        handoverStateService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    @RequestMapping(value = "/getByCode")
    public Result<HandoverState> findByCode(Integer code) {
        return ResultUtil.success(handoverStateService.findByCode(code));
    }

}
