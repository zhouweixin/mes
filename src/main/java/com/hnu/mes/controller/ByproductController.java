package com.hnu.mes.controller;

import com.hnu.mes.domain.Byproduct;
import com.hnu.mes.domain.Result;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.ByproductService;
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
 * @Date: 2018/6/24 8:24
 */
@RestController
@RequestMapping(value = "/byproduct")
public class ByproductController {
    @Autowired
    private ByproductService byproductService;


    /**
     * 新增
     * @param byproduct
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<Byproduct> add(@Valid Byproduct byproduct, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(byproductService.save(byproduct));
    }

    @RequestMapping(value = "/update")
    public Result<Byproduct> update(@Valid Byproduct byproduct, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        //判断是否重复
        if (byproductService.findByCode(byproduct.getCode()) == null) {
            return ResultUtil.error(new MesException(EnumException.UPDATE_FAILED_NOT_EXIST));
        }
        return ResultUtil.success(byproductService.save(byproduct));
    }

    /**
     * 批量删除
     * @param byproduct
     * @return
     */
    @RequestMapping(value = "/deleteByIdBatch")
    public Result<Object> deleteByIdBatch(@RequestBody Collection<Byproduct> byproduct) {
        byproductService.deleteInBatch(byproduct);
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
    public Result<Page<Byproduct>> getAllByPage(@RequestParam(value = "page" , defaultValue = "0" ) Integer page,
                                                  @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                  @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                                  @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(byproductService.findAllByPage(page , size , sortFieldName ,asc));
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
    @RequestMapping(value = "/getAllByNameLikeByPage")
    public Result<Page<Byproduct>> getAllByNameLikeByPage(@RequestParam(value = "name" , defaultValue = "") String name,
                                                              @RequestParam(value = "page" , defaultValue = "0") Integer page,
                                                              @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                              @RequestParam(value = "sortFieldName" , defaultValue = "batchNumber") String sortFieldName,
                                                              @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(byproductService.findByNameLike(name , page, size , sortFieldName , asc));
    }

    /**
     * 通过code删除
     * @param code
     * @return
     */
    @RequestMapping(value = "/deleteByCode")
    public Result<Object> deleteById(Integer code) {
        byproductService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    @RequestMapping(value = "/getByCode")
    public Result<Byproduct> findByCode(Integer code) {
        return ResultUtil.success(byproductService.findByCode(code));
    }

}
