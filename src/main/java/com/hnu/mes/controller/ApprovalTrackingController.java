package com.hnu.mes.controller;

import com.hnu.mes.domain.ApprovalTracking;
import com.hnu.mes.domain.Result;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.ApprovalTrackingService;
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
 * @Date: 2018/6/20 20:43
 */
@RestController
@RequestMapping(value = "/approvalTracking")
public class ApprovalTrackingController {
    @Autowired
    private ApprovalTrackingService approvalTrackingService;

    /**
     * 新增
     * @param approvalTracking
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<ApprovalTracking> add(@Valid ApprovalTracking approvalTracking, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(approvalTrackingService.save(approvalTracking));
    }

    @RequestMapping(value = "/update")
    public Result<ApprovalTracking> update(@Valid ApprovalTracking approvalTracking, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        //判断是否重复
        if (approvalTrackingService.findByCode(approvalTracking.getCode()) == null) {
            return ResultUtil.error(new MesException(EnumException.UPDATE_FAILED_NOT_EXIST));
        }
        return ResultUtil.success(approvalTrackingService.save(approvalTracking));
    }

    /**
     * 批量删除
     * @param approvalTracking
     * @return
     */
    @RequestMapping(value = "/deleteByIdBatch")
    public Result<Object> deleteByIdBatch(@RequestBody Collection<ApprovalTracking> approvalTracking) {
        approvalTrackingService.deleteInBatch(approvalTracking);
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
    public Result<Page<ApprovalTracking>> getAllByPage(@RequestParam(value = "page" , defaultValue = "0" ) Integer page,
                                                   @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                   @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                                   @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(approvalTrackingService.findAllByPage(page , size , sortFieldName ,asc));
    }

    /**
     * 通过物料打包编号模糊查询-分页
     * @param packagingCode
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    @RequestMapping(value = "/getByPackagingCodeLikeByPage")
    public Result<Page<ApprovalTracking>> getByPackagingCodeLikeByPage(@RequestParam(value = "packagingCode" , defaultValue = "") String packagingCode,
                                                                 @RequestParam(value = "page" , defaultValue = "0") Integer page,
                                                                 @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                                 @RequestParam(value = "sortFieldName" , defaultValue = "packagingCode") String sortFieldName,
                                                                 @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(approvalTrackingService.findByPackagingCodeLike(packagingCode , page, size , sortFieldName , asc));
    }

    /**
     * 通过code删除
     * @param code
     * @return
     */
    @RequestMapping(value = "/deleteByCode")
    public Result<Object> deleteById(Integer code) {
        approvalTrackingService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    @RequestMapping(value = "/getById")
    public Result<ApprovalTracking> findByCode(Integer code) {
        return ResultUtil.success(approvalTrackingService.findByCode(code));
    }

}
