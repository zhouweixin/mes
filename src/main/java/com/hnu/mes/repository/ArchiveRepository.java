package com.hnu.mes.repository;

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
}
