package com.hnu.mes.controller;

import com.hnu.mes.domain.ElectronicBalance;
import com.hnu.mes.domain.Result;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.ElectronicBalanceService;
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
 * @Date: Created in 16:07 2018/6/30
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/electronicBalance")
public class ElectronicBalanceController {
    @Autowired
    private ElectronicBalanceService electronicBalanceService;

    @RequestMapping(value = "/add")
    public Result<ElectronicBalance> save(ElectronicBalance electronicBalance) {

        //判断是否重复
        if (electronicBalance.getCode() != null && electronicBalanceService.findOne(electronicBalance.getCode()) != null) {
            return ResultUtil.error(new MesException(EnumException.CODE_DUPLICATE));
        }

        return ResultUtil.success(electronicBalanceService.save(electronicBalance));
    }

    /**
     * 更新
     * @param electronicBalance
     * @return
     */
    @RequestMapping(value = "/update")
    public Result<ElectronicBalance> update(ElectronicBalance electronicBalance) {

        //判断是否存在
        ElectronicBalance findOne = electronicBalanceService.findOne(electronicBalance.getCode());
        if (findOne == null) {
            return ResultUtil.error(new MesException(EnumException.UPDATE_FAILED_NOT_EXIST));
        }

        return ResultUtil.success(electronicBalanceService.save(electronicBalance));
    }

    @RequestMapping(value = "/deleteByCode")
    public Result<Object> delete(@RequestParam(value = "code") String code) {

        //判断是否存在
        ElectronicBalance findOne = electronicBalanceService.findOne(code);
        if (findOne == null) {
            return ResultUtil.error(new MesException(EnumException.DELETE_FAILED_NOT_EXIST));
        }

        electronicBalanceService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 批量删除
     *
     * @param electronicBalances
     * @return
     */
    @RequestMapping(value = "/deleteByBatchCode")
    public Result<Object> deleteByBatchCode(@RequestBody Set<ElectronicBalance> electronicBalances){
        electronicBalanceService.deleteInBatch(electronicBalances);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/getByCode")
    public Result<ElectronicBalance> findOne(@RequestParam(value = "code") String code) {
        //不存在时，会成功，data结果为null
        return ResultUtil.success(electronicBalanceService.findOne(code));
    }

    @RequestMapping(value = "/getAll")
    public Result<List<ElectronicBalance>> findAll() {
        return ResultUtil.success(electronicBalanceService.findAll());
    }

    @RequestMapping(value = "/getAllByPage")
    public Result<Page<ElectronicBalance>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                                         @RequestParam(value = "sort", defaultValue = "code") String sort,
                                         @RequestParam(value = "asc", defaultValue = "1") Integer asc) {
        /**
         * findAll
         * @Desciption 分页查询所有
         * @param [page, size, sort, asc]
         */
        return ResultUtil.success(electronicBalanceService.getElectronicBalanceByPage(page, size, sort, asc));
    }

    @RequestMapping(value = "/getAllByLikeNameByPage")
    public Result<Page<ElectronicBalance>> findAllByLikeNameByPage(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", defaultValue = "code") String sort,
            @RequestParam(value = "asc", defaultValue = "1") Integer asc) {
        /**
         * findAllByLikeNameByPage
         * @Desciption 分页模糊查询所有
         * @param [name, page, size, sort, asc]
         */
        return ResultUtil.success(electronicBalanceService.findAllByLikeNameByPage(name, page, size, sort, asc));
    }
}
