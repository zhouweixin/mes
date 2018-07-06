package com.hnu.mes.repository;

import com.hnu.mes.domain.Audit;
import com.hnu.mes.domain.ElectronicBalance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: WaveLee
 * @Date: 2018/6/29 14:27
 */
public interface AuditRepository extends JpaRepository<Audit,Integer> {
    /**
     * 通过电子秤编号查询
     * @param equipmentCode
     * @param pageable
     * @return
     */
    public Page<Audit> findByEquipmentCode_Code(Integer equipmentCode, Pageable pageable);

    /**
     * 通过电子秤编号确认状态查询
     * @return
     */
    public List<Audit> findByEquipmentCode_CodeAndConfirm(Integer equipmentCode,Integer confirm);

    /**
     * 通过确认状态查询
     * @param confirm
     * @param pageable
     * @return
     */
    public Page<Audit> findByConfirm(Integer confirm,Pageable pageable);
}
