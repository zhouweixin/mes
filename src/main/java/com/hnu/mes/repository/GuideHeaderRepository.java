package com.hnu.mes.repository;

import com.hnu.mes.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hnu.mes.domain.GuideHeader;

/**
 *
 * @author chenpingxiao
 *
 */
public interface GuideHeaderRepository extends JpaRepository<GuideHeader, String> {
    public GuideHeader findByEquipment(Equipment equipment);
}
