package com.hnu.mes.controller;

import com.hnu.mes.domain.*;
import com.hnu.mes.service.LossEntryHeaderService;
import com.hnu.mes.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 21:03 2018/5/30
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/lossEntryHeader")
public class LossEntryHeaderController {
    @Autowired
    private LossEntryHeaderService lossEntryHeaderService;

    /**
     * 新增
     *
     * @param lossEntryHeader
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<LossEntryHeader> add(@RequestBody LossEntryHeader lossEntryHeader) {
        return ResultUtil.success(lossEntryHeaderService.save(lossEntryHeader));
    }

    /**
     * 审核报损单
     *
     * @param status
     * @param note
     * @param nextAuditorCode
     * @param code
     * @return
     */
    @RequestMapping(value = "/audit")
    public Result<Object> audit(@RequestParam(value = "status", defaultValue = "1") Integer status,
                                @RequestParam(value = "note", defaultValue = "") String note,
                                @RequestParam(value = "curAuditorCode", defaultValue = "-1") String curAuditorCode,
                                @RequestParam(value = "nextAuditorCode", defaultValue = "-1") String nextAuditorCode,
                                @RequestParam(value = "code", defaultValue = "") Long code) {
        lossEntryHeaderService.audit(status, note, curAuditorCode, nextAuditorCode, code);
        return ResultUtil.success();
    }

    /**
     * 通过申请表编码查询剩余审核人
     *
     * @param code
     * @return
     */
    @RequestMapping(value = "/getRestAuditorByCode")
    public Result<List<User>> getRestAuditorByCode(@RequestParam(name = "code") Long code, @RequestParam(name = "curAuditorCode") String curAuditorCode) {
        return ResultUtil.success(lossEntryHeaderService.getRestAuditorByCode(code, curAuditorCode));
    }

    /**
     * 通过主键查询
     *
     * @param code
     * @return
     */
    @RequestMapping(value = "/getByCode")
    public Result<LossEntryHeader> getByCode(Long code){
        return ResultUtil.success(lossEntryHeaderService.findOne(code));
    }

    /**
     * 通过原料类型查询待审核的报损单
     *
     * @param rawType
     * @return
     */
    @RequestMapping(value = "/getByRawType")
    public Result<LossEntryHeader> getByRawType(RawType rawType){
        return ResultUtil.success(lossEntryHeaderService.findFirstByRawTypeAndAuditStatus(rawType, 1));
    }

    /**
     * 通过报损单表头查询审核记录
     *
     * @param lossEntryHeader
     * @return
     */
    @RequestMapping(value = "/getLossEntryAuditsByLossEntryHeader")
     public Result<List<LossEntryAudit>> getLossEntryAuditsByLossEntryHeader(LossEntryHeader lossEntryHeader){
        return ResultUtil.success(lossEntryHeaderService.findByLossEntryHeader(lossEntryHeader));
     }
}
