package com.hnu.mes.controller;

import com.hnu.mes.domain.BowlSampling;
import com.hnu.mes.domain.Result;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.BowlSamplingService;
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
 * @Date: 2018/6/16 20:58
 */
@RestController
@RequestMapping(value = "/bowlSampling")
public class BowlSamplingController {
    @Autowired
    private BowlSamplingService bowlSamplingService;

    /**
     * 新增
     * @param bowlSampling
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<BowlSampling> add(@Valid BowlSampling bowlSampling, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(bowlSamplingService.save(bowlSampling));
    }

    @RequestMapping(value = "/update")
    public Result<BowlSampling> update(@Valid BowlSampling bowlSampling, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        //判断是否重复
        if (bowlSamplingService.findByCode(bowlSampling.getCode()) == null) {
            return ResultUtil.error(new MesException(EnumException.UPDATE_FAILED_NOT_EXIST));
        }
        return ResultUtil.success(bowlSamplingService.save(bowlSampling));
    }

    /**
     * 批量删除
     * @param bowlSampling
     * @return
     */
    @RequestMapping(value = "/deleteByIdBatch")
    public Result<Object> deleteByIdBatch(@RequestBody Collection<BowlSampling> bowlSampling) {
        bowlSamplingService.deleteInBatch(bowlSampling);
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
    public Result<Page<BowlSampling>> getAllByPage(@RequestParam(value = "page" , defaultValue = "0" ) Integer page,
                                                @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                                @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(bowlSamplingService.findAllByPage(page , size , sortFieldName ,asc));
    }

    /**
     * 通过装钵机号模糊查询-分页
     * @param bowlCode
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    @RequestMapping(value = "/getByBowlCodeLikeByPage")
    public Result<Page<BowlSampling>> getByBowlCodeLikeByPage(@RequestParam(value = "bowlCode" , defaultValue = "") String bowlCode,
                                                           @RequestParam(value = "page" , defaultValue = "0") Integer page,
                                                           @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                           @RequestParam(value = "sortFieldName" , defaultValue = "bowlCode") String sortFieldName,
                                                           @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(bowlSamplingService.findByBowlCodeLike(bowlCode , page, size , sortFieldName , asc));
    }

    /**
     * 通过code删除
     * @param code
     * @return
     */
    @RequestMapping(value = "/deleteByCode")
    public Result<Object> deleteById(Integer code) {
        bowlSamplingService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    @RequestMapping(value = "/getById")
    public Result<BowlSampling> findByCode(Integer code) {
        return ResultUtil.success(bowlSamplingService.findByCode(code));
    }

}
