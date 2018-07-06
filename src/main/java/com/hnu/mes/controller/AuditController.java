package com.hnu.mes.controller;

import com.hnu.mes.domain.Audit;
import com.hnu.mes.domain.Result;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.AuditService;
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
 * @Date: 2018/6/29 14:42
 */
@RestController
@RequestMapping(value = "/audit")
public class AuditController {
    @Autowired
    private AuditService auditService;

    /**
     * 新增
     * @param audit
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<Audit> add(@Valid Audit audit, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(auditService.add(audit));
    }

    @RequestMapping(value = "/update")
    public Result<Audit> update(@Valid Audit audit, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        //判断是否重复
        if (auditService.findByCode(audit.getCode()) == null) {
            return ResultUtil.error(new MesException(EnumException.UPDATE_FAILED_NOT_EXIST));
        }
        return ResultUtil.success(auditService.update(audit));
    }

    /**
     * 批量删除
     * @param audit
     * @return
     */
    @RequestMapping(value = "/deleteByIdBatch")
    public Result<Object> deleteByIdBatch(@RequestBody Collection<Audit> audit) {
        auditService.deleteInBatch(audit);
        return ResultUtil.success();
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/getAll")
    public Result<List<Audit>> getAll(){
        return ResultUtil.success(auditService.findAll());
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
    public Result<Page<Audit>> getAllByPage(@RequestParam(value = "page" , defaultValue = "0" ) Integer page,
                                                @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                                @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(auditService.findAllByPage(page , size , sortFieldName ,asc));
    }

    /**
     * 通过电子秤编号查询-分页
     * @param equipmentCode
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    @RequestMapping(value = "/getByEquipmentCodeByPage")
    public Result<Page<Audit>> getByEquipmentCodeByPage(@RequestParam(value = "equipmentCode" , defaultValue = "") Integer equipmentCode,
                                                          @RequestParam(value = "page" , defaultValue = "0") Integer page,
                                                          @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                          @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                                          @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(auditService.findByEquipmentCodeByPage(equipmentCode , page, size , sortFieldName , asc));
    }

    /**
     * 根据电子秤编号和确认状态查询
     * @param equipmentCode
     * @param confirm
     * @return
     */
    @RequestMapping(value = "/getByEquipmentCodeAndConfirm")
    public Result<List<Audit>> getByEquipmentCodeAndConfirm(Integer equipmentCode,Integer confirm){
        return ResultUtil.success(auditService.findByEquipmentCodeAndConfirm(equipmentCode,confirm));
    }

    /**
     * 根据确认状态查询-分页
     * @param confirm
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    @RequestMapping(value = "/getByConfirm")
    public Result<Page<Audit>> findByConfirm(@RequestParam(value = "confirm" , defaultValue = "") Integer confirm,
                                                        @RequestParam(value = "page" , defaultValue = "0") Integer page,
                                                        @RequestParam(value = "size" , defaultValue = "10") Integer size,
                                                        @RequestParam(value = "sortFieldName" , defaultValue = "code") String sortFieldName,
                                                        @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {
        return ResultUtil.success(auditService.findByConfirm(confirm , page, size , sortFieldName , asc));
    }

    /**
     * 通过code删除
     * @param code
     * @return
     */
    @RequestMapping(value = "/deleteByCode")
    public Result<Object> deleteById(Integer code) {
        auditService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 通过code查询
     * @param code
     * @return
     */
    @RequestMapping(value = "/getByCode")
    public Result<Audit> findByCode(Integer code) {
        return ResultUtil.success(auditService.findByCode(code));
    }

}
