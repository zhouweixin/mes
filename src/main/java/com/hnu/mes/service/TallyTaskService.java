package com.hnu.mes.service;

import com.hnu.mes.domain.TallyTask;
import com.hnu.mes.repository.TallyTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 15:36 2018/6/17
 * @Modified By:
 */
@Service
public class TallyTaskService {
    @Autowired
    private TallyTaskRepository tallyTaskRepository;

    /**
     * 通过主键查询
     *
     * @param code
     * @return
     */
    public TallyTask findOne(Long code){
        return tallyTaskRepository.findOne(code);
    }
}
