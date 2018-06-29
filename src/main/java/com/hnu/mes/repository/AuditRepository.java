package com.hnu.mes.repository;

import com.hnu.mes.domain.Audit;
import com.hnu.mes.domain.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/29 14:27
 */
public interface AuditRepository extends JpaRepository<Audit,Integer> {
    public Page<Audit> findByEquipmentCode(Equipment equipmentCode, Pageable pageable);
}
