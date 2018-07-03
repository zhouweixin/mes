package com.hnu.mes.controller;

import com.hnu.mes.domain.KilnOrder;
import com.hnu.mes.domain.Result;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.KilnOrderService;
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
 * @Date: 2018/6/16 10:40
 */
@RestController
@RequestMapping(value = "/kilnOrder")
public class KilnOrderController {
    @Autowired
    KilnOrderService kilnOrderService;


    /**
     * 新增
     * @param kilnOrder
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<KilnOrder> add(@RequestBody KilnOrder kilnOrder){

        return ResultUtil.success(kilnOrderService.add(kilnOrder));
    }

    @RequestMapping(value = "/update")
    public Result<KilnOrder> update(@RequestBody KilnOrder kilnOrder){

        return ResultUtil.success(kilnOrderService.update(kilnOrder));
    }

    /**
     * 批量删除
     * @param kilnOrder
     * @return
     */
    @RequestMapping(value = "/deleteByIdBatch")
    public Result<Object> deleteByIdBatch(@RequestBody Collection<KilnOrder> kilnOrder) {
        kilnOrderService.deleteInBatch(kilnOrder);
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
    public Result<Page<KilnOrder>> getAllByPage(@RequestParam(value = "page" , defaultValue = "0" ) Integer page,
                                                   @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                   @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                                   @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(kilnOrderService.findAllByPage(page , size , sortFieldName ,asc));
    }

    /**
     * 通过窑炉编号模糊查询-分页
     * @param kilnCode
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    @RequestMapping(value = "/getByKilnCodeLikeByPage")
    public Result<Page<KilnOrder>> getByKilnCodeLikeByPage(@RequestParam(value = "kilnCode" , defaultValue = "") String kilnCode,
                                                          @RequestParam(value = "page" , defaultValue = "0") Integer page,
                                                          @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                          @RequestParam(value = "sortFieldName" , defaultValue = "kilnCode") String sortFieldName,
                                                          @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(kilnOrderService.findByKilnCodeLike(kilnCode , page, size , sortFieldName , asc));
    }

    /**
     * 通过code删除
     * @param code
     * @return
     */
    @RequestMapping(value = "/deleteByCode")
    public Result<Object> deleteById(Integer code) {
        kilnOrderService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    @RequestMapping(value = "/getById")
    public Result<KilnOrder> findByCode(Integer code) {
        return ResultUtil.success(kilnOrderService.findByCode(code));
    }

}
