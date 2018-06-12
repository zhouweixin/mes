package com.hnu.mes.controller;

import com.hnu.mes.domain.Result;
import com.hnu.mes.domain.SupplierType;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.SupplierTypeService;
import com.hnu.mes.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 17:40 2018/6/6
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/supplierType")
public class SupplierTypeController {
    /** 注入 */
    @Autowired
    private SupplierTypeService supplierTypeService;

    /**
     * 新增
     *
     * @param supplierType
     * @return
     */
    @PostMapping(value = "/add")
    public Result<SupplierType> save(@Valid SupplierType supplierType, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }

        // 判断是否重复
        SupplierType findOne = supplierTypeService.findOne(supplierType.getCode());
        if (findOne != null) {
            return ResultUtil.error(new MesException(EnumException.CODE_DUPLICATE));
        }

        return ResultUtil.success(supplierTypeService.save(supplierType));
    }

    /**
     * 更新
     *
     * @param supplierType
     * @return
     */
    @PostMapping(value = "/update")
    public Result<SupplierType> update(@Valid SupplierType supplierType, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }

        // 判断是否存在
        SupplierType findOne = supplierTypeService.findOne(supplierType.getCode());
        if (findOne == null) {
            return ResultUtil.error(new MesException(EnumException.UPDATE_FAILED_NOT_EXIST));
        }

        return ResultUtil.success(supplierTypeService.save(supplierType));
    }

    /**
     * 删除
     *
     * @param code
     */
    @PostMapping(value = "/deleteByCode")
    public Result<Object> delete(@RequestParam(value = "code") int code) {
        if(supplierTypeService.findOne(code) == null){
            return ResultUtil.error(new MesException(EnumException.DELETE_FAILED_NOT_EXIST));
        }

        supplierTypeService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 批量删除
     *
     * @param supplierTypes
     * @return
     */
    @PostMapping(value = "/deleteByBatchCode")
    public Result<Object> deleteByBatchCode(@RequestBody Set<SupplierType> supplierTypes){
        supplierTypeService.deleteInBatch(supplierTypes);
        return ResultUtil.success();
    }

    /**
     * 查找
     *
     * @param code
     * @return
     */
    @PostMapping(value = "/getByCode")
    public Result<SupplierType> findOne(@RequestParam(value = "code") int code) {

        return ResultUtil.success(supplierTypeService.findOne(code));
    }

    /**
     * 查找所有
     *
     * @return
     */
    @GetMapping(value = "/getAll")
    public Result<List<SupplierType>> findAll() {
        return ResultUtil.success(supplierTypeService.findAll());
    }

    /**
     * 查询所有-分页
     *
     * @param page
     *            当前页,从0开始,默认是0
     * @param size
     *            每页的记录数,默认是10
     * @param sort
     *            排序的字段名,默认是code
     * @param asc
     *            排序的方式,0是减序,1是增序,默认是增序
     * @return
     */
    @PostMapping(value = "/getAllByPage")
    public Result<Page<SupplierType>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                            @RequestParam(value = "size", defaultValue = "10") Integer size,
                                            @RequestParam(value = "sort", defaultValue = "code") String sort,
                                            @RequestParam(value = "asc", defaultValue = "1") Integer asc) {
        return ResultUtil.success(supplierTypeService.getSupplierTypeByPage(page, size, sort, asc));
    }

    /**
     * 通过名称模糊查询所有-分页
     *
     * @param name
     *            名称
     * @param page
     *            当前页,从0开始,默认是0
     * @param size
     *            每页的记录数,默认是10
     * @param sort
     *            排序的字段名,默认是code
     * @param asc
     *            排序的方式,0是减序,1是增序,默认是增序
     * @return
     */
    @PostMapping(value = "/getAllByLikeNameByPage")
    public Result<Page<SupplierType>> findAllByLikeNameByPage(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", defaultValue = "code") String sort,
            @RequestParam(value = "asc", defaultValue = "1") Integer asc) {
        return ResultUtil.success(supplierTypeService.findAllByLikeNameByPage(name, page, size, sort, asc));
    }
}
