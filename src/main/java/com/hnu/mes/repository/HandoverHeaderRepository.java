package com.hnu.mes.repository;

import com.hnu.mes.domain.HandoverHeader;
import com.hnu.mes.domain.Jobs;
import com.hnu.mes.domain.JobsHandover;
import com.hnu.mes.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 11:50
 */
public interface HandoverHeaderRepository extends JpaRepository<HandoverHeader,Integer> {

    /**
     * 通过岗位id查询
     * @param jobsCode
     * @param pageable
     * @return
     */
    public Page<HandoverHeader> findByJobsCode_Code(Integer jobsCode, Pageable pageable);

    /**
     * 通过岗位id和交班人id查询
     * @param jobsCode
     * @param user
     * @return
     */
    public List<HandoverHeader> findByJobsCode_CodeAndShifterCode_Code(Integer jobsCode, String user);

    /**
     * 通过岗位id和接班人id查询
     * @param jobsCode
     * @param user
     * @return
     */
    public List<HandoverHeader> findByJobsCode_CodeAndSuccessorCode_Code(Integer jobsCode, String user);

    public Page<HandoverHeader> findByJobsCode_NameLikeAndHandoverDate(String jobsName, Date handoverDate,Pageable pageable);
}
