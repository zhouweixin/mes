package com.hnu.mes.controller;

import com.hnu.mes.domain.ProcessTracking;
import com.hnu.mes.domain.Result;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.ProcessTrackingService;
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
 * @Date: 2018/6/20 14:58
 */
@RestController
@RequestMapping(value = "/processTracking")
public class ProcessTrackingController {
    @Autowired
    private ProcessTrackingService processTrackingService;


    /**
     * 新增
     * @param processTracking
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<ProcessTracking> add(@Valid ProcessTracking processTracking, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(processTrackingService.save(processTracking));
    }

    @RequestMapping(value = "/update")
    public Result<ProcessTracking> update(@Valid ProcessTracking processTracking, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        //判断是否重复
        if (processTrackingService.findByCode(processTracking.getCode()) == null) {
            return ResultUtil.error(new MesException(EnumException.UPDATE_FAILED_NOT_EXIST));
        }
        return ResultUtil.success(processTrackingService.save(processTracking));
    }

    /**
     * 批量删除
     * @param processTracking
     * @return
     */
    @RequestMapping(value = "/deleteByIdBatch")
    public Result<Object> deleteByIdBatch(@RequestBody Collection<ProcessTracking> processTracking) {
        processTrackingService.deleteInBatch(processTracking);
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
    public Result<Page<ProcessTracking>> getAllByPage(@RequestParam(value = "page" , defaultValue = "0" ) Integer page,
                                                   @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                   @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                                   @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(processTrackingService.findAllByPage(page , size , sortFieldName ,asc));
    }

    /**
     * 通过预烧物料编号模糊查询-分页
     * @param premixedCode
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    @RequestMapping(value = "/getByPremixedCodeLikeByPage")
    public Result<Page<ProcessTracking>> getByBatchNumberLikeByPage(@RequestParam(value = "premixedCode" , defaultValue = "") String premixedCode,
                                                                    @RequestParam(value = "page" , defaultValue = "0") Integer page,
                                                                    @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                                    @RequestParam(value = "sortFieldName" , defaultValue = "premixedCode") String sortFieldName,
                                                                    @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(processTrackingService.findByPremixedCodeLike(premixedCode , page, size , sortFieldName , asc));
    }

    /**
     * 通过code删除
     * @param code
     * @return
     */
    @RequestMapping(value = "/deleteByCode")
    public Result<Object> deleteById(Integer code) {
        processTrackingService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    @RequestMapping(value = "/getById")
    public Result<ProcessTracking> findByCode(Integer code) {
        return ResultUtil.success(processTrackingService.findByCode(code));
    }

}
