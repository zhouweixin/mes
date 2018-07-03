package com.hnu.mes.controller;

import com.hnu.mes.domain.Jobs;
import com.hnu.mes.domain.Result;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.repository.JobsRepository;
import com.hnu.mes.service.JobsService;
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
 * @Date: 2018/6/24 12:04
 */
@RestController
@RequestMapping(value = "/jobs")
public class JobsController {
    @Autowired
    private JobsService jobsService;

    /**
     * 新增
     * @param jobs
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<Jobs> add(@RequestBody Jobs jobs ){
        return ResultUtil.success(jobsService.add(jobs));
    }

    @RequestMapping(value = "/update")
    public Result<Jobs> update(@RequestBody Jobs jobs ){
        return ResultUtil.success(jobsService.update(jobs));
    }

    /**
     * 批量删除
     * @param jobs
     * @return
     */
    @RequestMapping(value = "/deleteByIdBatch")
    public Result<Object> deleteByIdBatch(@RequestBody Collection<Jobs> jobs) {
        jobsService.deleteInBatch(jobs);
        return ResultUtil.success();
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/getAll")
    public Result<List<Jobs>> getAll(){
        return ResultUtil.success(jobsService.findAll());
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
    public Result<Page<Jobs>> getAllByPage(@RequestParam(value = "page" , defaultValue = "0" ) Integer page,
                                                @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                                @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(jobsService.findAllByPage(page , size , sortFieldName ,asc));
    }

    /**
     * 通过code删除
     * @param code
     * @return
     */
    @RequestMapping(value = "/deleteByCode")
    public Result<Object> deleteById(Integer code) {
        jobsService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    @RequestMapping(value = "/getByCode")
    public Result<Jobs> findByCode(Integer code) {
        return ResultUtil.success(jobsService.findByCode(code));
    }

}
