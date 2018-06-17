package com.hnu.mes.service;

import com.hnu.mes.domain.Tally;
import com.hnu.mes.domain.TallyTask;
import com.hnu.mes.domain.TallyTaskHeader;
import com.hnu.mes.domain.User;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.repository.TallyRepository;
import com.hnu.mes.repository.TallyTaskHeaderRepository;
import com.hnu.mes.repository.TallyTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 14:20 2018/6/17
 * @Modified By:
 */
@Service
public class TallyTaskHeaderService {
    @Autowired
    private TallyTaskHeaderRepository tallyTaskHeaderRepository;

    @Autowired
    private TallyTaskRepository tallyTaskRepository;

    @Autowired
    private TallyRepository tallyRepository;

    /**
     * 通过用户和状态查询
     *
     * @param user
     * @param status
     * @return
     */
    public List<TallyTaskHeader> findByUserAndStatus(User user, Integer status){
        return tallyTaskHeaderRepository.findByUserAndStatus(user, status);
    }

    /**
     * 点检
     */
    @Transactional
    public void tally(Long tallyTaskHeaderCode, Long tallyTaskCode, Integer result) {
        TallyTask tallyTask = tallyTaskRepository.findOne(tallyTaskCode);
        if(tallyTask == null){
            // 点检失败, 任务不存在
            throw new MesException(EnumException.TALLY_FAILED_TASK_NOT_EXIST);
        }

        if(tallyTask.getStatus() == 1){
            // 点检失败, 任务已完成
            throw new MesException(EnumException.TALLY_FAILED_TALLY);
        }

        if(tallyTask.getStatus() == 2){
            // 点检失败, 任务已过期
            throw new MesException(EnumException.TALLY_FAILED_TASK_DEADLINE);
        }

        // 更改状态
        tallyTaskRepository.updateStatusByCode(1, new Date(), tallyTaskCode);

        // 生成点检记录
        Tally tally = new Tally(tallyTask);
        // 设置审核结果
        tally.setInspectorStatus(result);
        // 持久化
        tallyRepository.save(tally);

        // 判断是否存在未点检的
        TallyTaskHeader tallyTaskHeader = tallyTaskHeaderRepository.findOne(tallyTaskHeaderCode);
        boolean isFind = false;
        if(tallyTaskHeader != null && tallyTaskHeader.getTallyTasks() != null && tallyTaskHeader.getTallyTasks().size() > 0){
            for(TallyTask tt : tallyTaskHeader.getTallyTasks()){
                if(tt.getCode() != tallyTask.getCode() && tt.getStatus() == 0){
                    isFind = true;
                }
            }
        }

        // 如果全都点检了,更新任务头的状态
        if(isFind == false){
            tallyTaskHeaderRepository.updateStatusByCode(1, new Date(), tallyTaskHeaderCode);
        }
    }

    /**
     * 通过主键查询
     *
     * @param code
     * @return
     */
    public TallyTaskHeader findOne(Long code) {
        return tallyTaskHeaderRepository.findOne(code);
    }
}
