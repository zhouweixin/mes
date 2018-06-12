package com.hnu.mes.service;

import com.hnu.mes.domain.Pdf;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.repository.ArchiveRepository;
import com.hnu.mes.repository.PdfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 13:14 2018/6/8
 * @Modified By:
 */
@Service
public class PdfService {
    @Autowired
    private PdfRepository pdfRepository;

    @Autowired
    private ArchiveRepository archiveRepository;

    public Pdf save(Pdf pdf) {
        return pdfRepository.save(pdf);
    }

    public Pdf findOne(Long code) {
        return pdfRepository.findOne(code);
    }

    /**
     * 删除
     *
     * @param code
     */
    public void delete(Long code) {

        if (archiveRepository.findFirstByDocument(code) != null) {
            throw new MesException(EnumException.DELETE_FAILED_REF_KEY_EXISTS);
        }

        pdfRepository.delete(code);
    }

    /**
     * 批量删除
     *
     * @param images
     */
    public void deleteInBatch(Set<Pdf> images) {
        pdfRepository.deleteInBatch(images);
    }
}
