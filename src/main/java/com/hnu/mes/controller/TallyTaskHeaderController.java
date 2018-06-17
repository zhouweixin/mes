package com.hnu.mes.controller;

import com.hnu.mes.domain.Result;
import com.hnu.mes.domain.TallyTask;
import com.hnu.mes.domain.TallyTaskHeader;
import com.hnu.mes.domain.User;
import com.hnu.mes.service.TallyTaskHeaderService;
import com.hnu.mes.service.TallyTaskService;
import com.hnu.mes.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 14:20 2018/6/17
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/tallyTaskHeader")
public class TallyTaskHeaderController {
    @Autowired
    private TallyTaskHeaderService tallyTaskHeaderService;

    @Autowired
    private TallyTaskService tallyTaskService;

    /**
     * 通过状态点检人和状态查询
     *
     * @param user
     * @param status
     * @return
     */
    @RequestMapping(value = "/getByUserAndStatus")
    public Result<List<TallyTaskHeader>> getByUserAndStatus(User user, Integer status){
        return ResultUtil.success(tallyTaskHeaderService.findByUserAndStatus(user, status));
    }

    /**
     * 点检
     *
     * @return
     */
    @RequestMapping(value = "/tally")
    public Result<Object> tally(Long tallyTaskHeaderCode, Long tallyTaskCode, Integer result){
        tallyTaskHeaderService.tally(tallyTaskHeaderCode, tallyTaskCode, result);
        return ResultUtil.success();
    }

    /**
     * 通过编码查询任务头
     *
     * @param code
     * @return
     */
    @RequestMapping(value = "/getTallyTaskHeaderByCode")
    public Result<TallyTaskHeader> getTallyTaskHeaderByCode(Long code){
        return ResultUtil.success(tallyTaskHeaderService.findOne(code));
    }

    /**
     * 通过编码查询任务
     *
     * @param code
     * @return
     */
    @RequestMapping(value = "/getTallyTaskByCode")
    public Result<TallyTask> getTallyTaskByCode(Long code){
        return  ResultUtil.success(tallyTaskService.findOne(code));
    }
}
