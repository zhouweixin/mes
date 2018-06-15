package com.hnu.mes.controller;

import com.hnu.mes.domain.ProductOrder;
import com.hnu.mes.domain.Result;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.ProductOrderService;
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
 * @Date: 2018/6/14 22:21
 */
@RestController
@RequestMapping(value = "/productOrder")
public class ProductOrderController {
    @Autowired
    ProductOrderService productOrderService;

    /**
     * 新增
     * @param productOrder
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<ProductOrder> add(@Valid ProductOrder productOrder, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(productOrderService.save(productOrder));
    }

    @RequestMapping(value = "/update")
    public Result<ProductOrder> update(@Valid ProductOrder productOrder, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        //判断是否重复
        if (productOrderService.findByCode(productOrder.getCode()) == null) {
            return ResultUtil.error(new MesException(EnumException.UPDATE_FAILED_NOT_EXIST));
        }
        return ResultUtil.success(productOrderService.save(productOrder));
    }

    /**
     * 批量删除
     * @param productOrder
     * @return
     */
    @RequestMapping(value = "/deleteByIdBatch")
    public Result<Object> deleteByIdBatch(@RequestBody Collection<ProductOrder> productOrder) {
        productOrderService.deleteInBatch(productOrder);
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
    public Result<Page<ProductOrder>> getAllByPage(@RequestParam(value = "page" , defaultValue = "0" ) Integer page,
                                            @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                            @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                            @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(productOrderService.findAllByPage(page , size , sortFieldName ,asc));
    }

    /**
     * 通过批号模糊查询-分页
     * @param batchNumber
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    @RequestMapping(value = "/getByBatchNumberLikeByPage")
    public Result<Page<ProductOrder>> getByNameLikeByPage(@RequestParam(value = "batchNumber" , defaultValue = "") String batchNumber,
                                                     @RequestParam(value = "page" , defaultValue = "0") Integer page,
                                                     @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                     @RequestParam(value = "sortFieldName" , defaultValue = "id") String sortFieldName,
                                                     @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(productOrderService.findByNameLikeByPage(batchNumber , page, size , sortFieldName , asc));
    }

    /**
     * 通过code删除
     * @param code
     * @return
     */
    @RequestMapping(value = "/deleteByCode")
    public Result<Object> deleteById(Integer code) {
        productOrderService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    @RequestMapping(value = "/getById")
    public Result<ProductOrder> findByCode(Integer code) {
        return ResultUtil.success(productOrderService.findByCode(code));
    }

}
