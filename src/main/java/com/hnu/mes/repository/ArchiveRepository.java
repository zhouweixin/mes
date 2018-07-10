package com.hnu.mes.repository;

import com.hnu.mes.domain.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hnu.mes.domain.Archive;

import java.util.Collection;

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


    /**
     * 通过名称查询-分页
     *
     * @param name
     * @param pageable
     * @return
     */
    public Page<Archive> findByNameLike(String name, Pageable pageable);

    /**
     * 通过设备查询-分页
     *
     * @param equipment
     * @return
     */
    public Page<Archive> findByEquipmentIn(Collection<Equipment> equipment, Pageable pageable);
}
