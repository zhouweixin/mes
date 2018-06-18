package com.hnu.mes.repository;

import com.hnu.mes.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hnu.mes.domain.Archive;

/**
 *
 * @author chenpingxiao
 *
 */
public interface ArchiveRepository extends JpaRepository<Archive, Long> {
    /**
     * 通过文档查询
     *
     * @param document
     * @return
     */
    public Archive findFirstByDocument(Long document);

    /**
     * 通过设备查询
     *
     * @param equipment
     * @return
     */
    public Archive findFirstByEquipment(Equipment equipment);
}
