package com.hnu.mes.controller;

import com.hnu.mes.domain.Jobs;
import com.hnu.mes.domain.JobsHandover;
import com.hnu.mes.domain.Result;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.JobsHandoverService;
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
 * @Date: 2018/6/24 12:07
 */
@RestController
@RequestMapping(value = "/jobsHandover")
public class JobsHandoverController {
    @Autowired
    private JobsHandoverService jobsHandoverService;

    /**
     * 新增
     * @param jobsHandover
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<JobsHandover> add(@Valid JobsHandover jobsHandover, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(jobsHandoverService.save(jobsHandover));
    }

    @RequestMapping(value = "/update")
    public Result<JobsHandover> update(@Valid JobsHandover jobsHandover, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        //判断是否重复
        if (jobsHandoverService.findByCode(jobsHandover.getCode()) == null) {
            return ResultUtil.error(new MesException(EnumException.UPDATE_FAILED_NOT_EXIST));
        }
        return ResultUtil.success(jobsHandoverService.save(jobsHandover));
    }

    /**
     * 批量删除
     * @param jobsHandover
     * @return
     */
    @RequestMapping(value = "/deleteByIdBatch")
    public Result<Object> deleteByIdBatch(@RequestBody Collection<JobsHandover> jobsHandover) {
        jobsHandoverService.deleteInBatch(jobsHandover);
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
    public Result<Page<JobsHandover>> getAllByPage(@RequestParam(value = "page" , defaultValue = "0" ) Integer page,
                                                @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                                @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(jobsHandoverService.findAllByPage(page , size , sortFieldName ,asc));
    }
    /**
     * 通过岗位编号查询-分页
     * @param jobsCode
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    @RequestMapping(value = "/getByJobsCodeByPage")
    public Result<Page<JobsHandover>> findByJobsCodeByPage(@RequestParam(value = "jobsCode" , defaultValue = "") Integer jobsCode,
                                                           @RequestParam(value = "page" , defaultValue = "0") Integer page,
                                                           @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                           @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                                           @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(jobsHandoverService.findByJobsCodeByPage(jobsCode , page, size , sortFieldName , asc));
    }

    /**
     * 通过岗位编号和交班人编号查询
     * @param jobsCode
     * @param shifterCode
     * @return
     */
    @RequestMapping(value = "/getByJobsCodeAndShifterCode")
    public Result<List<JobsHandover>> findByJobsCodeAndShifterCode(Integer jobsCode,String shifterCode){
        return ResultUtil.success(jobsHandoverService.findByJobsCodeAndRecordCode(jobsCode,shifterCode));
    }
    /**
     * 通过code删除
     * @param code
     * @return
     */
    @RequestMapping(value = "/deleteByCode")
    public Result<Object> deleteById(Integer code) {
        jobsHandoverService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    @RequestMapping(value = "/getByCode")
    public Result<JobsHandover> findByCode(Integer code) {
        return ResultUtil.success(jobsHandoverService.findByCode(code));
    }

}
