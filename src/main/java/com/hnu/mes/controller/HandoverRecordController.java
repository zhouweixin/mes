package com.hnu.mes.controller;

import com.hnu.mes.domain.HandoverRecord;
import com.hnu.mes.domain.Result;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.HandoverRecordService;
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
 * @Date: 2018/6/24 12:11
 */
@RestController
@RequestMapping(value = "/handoverRecord")
public class HandoverRecordController {
    @Autowired
    private HandoverRecordService handoverRecordService;


    /**
     * 新增
     * @param handoverRecord
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<HandoverRecord> add(@Valid HandoverRecord handoverRecord, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(handoverRecordService.save(handoverRecord));
    }

    @RequestMapping(value = "/update")
    public Result<HandoverRecord> update(@Valid HandoverRecord handoverRecord, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        //判断是否重复
        if (handoverRecordService.findByCode(handoverRecord.getCode()) == null) {
            return ResultUtil.error(new MesException(EnumException.UPDATE_FAILED_NOT_EXIST));
        }
        return ResultUtil.success(handoverRecordService.save(handoverRecord));
    }

    /**
     * 批量删除
     * @param handoverRecord
     * @return
     */
    @RequestMapping(value = "/deleteByIdBatch")
    public Result<Object> deleteByIdBatch(@RequestBody Collection<HandoverRecord> handoverRecord) {
        handoverRecordService.deleteInBatch(handoverRecord);
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
    public Result<Page<HandoverRecord>> getAllByPage(@RequestParam(value = "page" , defaultValue = "0" ) Integer page,
                                                @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                                @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(handoverRecordService.findAllByPage(page , size , sortFieldName ,asc));
    }

    /**
     * 通过code删除
     * @param code
     * @return
     */
    @RequestMapping(value = "/deleteByCode")
    public Result<Object> deleteById(Integer code) {
        handoverRecordService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    @RequestMapping(value = "/getByCode")
    public Result<HandoverRecord> findByCode(Integer code) {
        return ResultUtil.success(handoverRecordService.findByCode(code));
    }

}
