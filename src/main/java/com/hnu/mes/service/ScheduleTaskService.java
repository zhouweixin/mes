package com.hnu.mes.service;

import com.hnu.mes.domain.*;
import com.hnu.mes.repository.GuideHeaderRepository;
import com.hnu.mes.repository.TallyRepository;
import com.hnu.mes.repository.TallyTaskHeaderRepository;
import com.hnu.mes.repository.TallyTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 21:03 2018/6/16
 * @Modified By:
 */
@Configuration
@EnableScheduling
@Component
public class ScheduleTaskService {

    @Autowired
    private GuideHeaderRepository guideHeaderRepository;

    @Autowired
    private TallyTaskHeaderRepository tallyTaskHeaderRepository;

    @Autowired
    private TallyTaskRepository tallyTaskRepository;

    @Autowired
    private TallyRepository tallyRepository;

    @Transactional
//    @Scheduled(cron = "0 0 0,12 * * ?")
    @Scheduled(fixedRate = 120000)
    public void execute() {

        // 创建当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);

        List<TallyTaskHeader> tallyTaskHeaders = new ArrayList<>();

        // 查询所有指导书
        List<GuideHeader> guiderHeaders = guideHeaderRepository.findAll();
        for (GuideHeader guideHeader : guiderHeaders) {
            List<Guide> guides = guideHeader.getGuides();

            if (guides == null || guides.size() == 0) {
                continue;
            }

            // 创建指导书头
            TallyTaskHeader tallyTaskHeader = new TallyTaskHeader(guideHeader);

            boolean isFind = false;

            // 遍历每一个内容
            for (Guide guide : guides) {
                TallyTask hisTallyTask = tallyTaskRepository.findFirstByGuideAndStatus(guide, 0);

                // 取周期
                Cycle cycle = guide.getCycle();
                if (cycle != null && cycle.getCode() != null) {
                    switch (cycle.getCode()){
                        case "1":
                            // 消去历史记录
                            if(hisTallyTask != null){
                                // 生成空的点检记录
                                createEmptyTally(hisTallyTask, guideHeader);
                                isFind = true;
                            }

                            // 0点或12点创建
                            tallyTaskHeader.getTallyTasks().add(new TallyTask(guide, guideHeader.getEquipment()));
                            break;
                        case "2":
                            // 只有0点才创建
                            if(calendar.get(Calendar.HOUR_OF_DAY) == 0){

                                // 消去历史记录
                                if(hisTallyTask != null){
                                    // 生成空的点检记录
                                    createEmptyTally(hisTallyTask, guideHeader);
                                    isFind = true;
                                }

                                tallyTaskHeader.getTallyTasks().add(new TallyTask(guide, guideHeader.getEquipment()));
                            }
                            break;
                        case "3":
                            // 只有周一才创建
                            if(calendar.get(Calendar.DAY_OF_WEEK) == 2){

                                // 消去历史记录
                                if(hisTallyTask != null){
                                    // 生成空的点检记录
                                    createEmptyTally(hisTallyTask, guideHeader);
                                    isFind = true;
                                }

                                tallyTaskHeader.getTallyTasks().add(new TallyTask(guide, guideHeader.getEquipment()));
                            }
                            break;
                        case "4":
                            // 只有1号才创建
                            if(calendar.get(Calendar.DAY_OF_MONTH) == 1){

                                // 消去历史记录
                                if(hisTallyTask != null){
                                    // 生成空的点检记录
                                    createEmptyTally(hisTallyTask, guideHeader);
                                    isFind = true;
                                }

                                tallyTaskHeader.getTallyTasks().add(new TallyTask(guide, guideHeader.getEquipment()));
                            }
                            break;
                    }
                }
            }

            if(tallyTaskHeader.getTallyTasks() != null && tallyTaskHeader.getTallyTasks().size() > 0) {
                tallyTaskHeaders.add(tallyTaskHeader);
            }

            if(isFind){
                TallyTaskHeader hisTallyTaskHeader = tallyTaskHeaderRepository.findFirstByGuideHeaderAndStatus(guideHeader, 0);
                if(hisTallyTaskHeader != null){
                    tallyTaskHeaderRepository.updateStatusByCode(2, new Date(), hisTallyTaskHeader.getCode());
                }
            }
        }

        List<TallyTaskHeader> save = tallyTaskHeaderRepository.save(tallyTaskHeaders);
        System.out.printf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss 创建任务数: ").format(new Date()) + save.size());
    }

    /**
     * 生成空的点检记录
     * @param tallyTask
     */
    @Transactional
    public void createEmptyTally(TallyTask tallyTask, GuideHeader guideHeader){

        // 生成空的点检记录
        Tally tally = new Tally(tallyTask);
        // 设置审核状态为未审核
        tally.setInspectorStatus(0);
        tallyRepository.save(tally);

        // 修改点检表为已失效
        tallyTaskRepository.updateStatusByCode(2, new Date(), tallyTask.getCode());
    }
}
