package com.hnu.mes.repository;

import com.hnu.mes.domain.HandoverHeader;
import com.hnu.mes.domain.HandoverRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/24 11:55
 */
public interface HandoverRecordRepository extends JpaRepository<HandoverRecord,Integer> {
    public HandoverRecord findByHeaderCode(HandoverHeader handoverHeader);
}
