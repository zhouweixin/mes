package com.hnu.mes.service;

import com.hnu.mes.domain.Image;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.repository.GuideRepository;
import com.hnu.mes.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 18:07 2018/6/6
 * @Modified By:
 */
@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private GuideRepository guideRepository;

    /**
     * 新增
     *
     * @param image
     */
    public Image save(Image image){
        return imageRepository.save(image);
    }

    /**
     * 通过主键查询
     *
     * @param code
     * @return
     */
    public Image findOne(Long code){
        return imageRepository.findOne(code);
    }

    /**
     * 删除
     *
     * @param code
     */
    public void delete(Long code){

        if(guideRepository.findFirstByImageCode(code) != null){
            throw new MesException(EnumException.DELETE_FAILED_REF_KEY_EXISTS);
        }

        imageRepository.delete(code);
    }

    /**
     * 批量删除
     *
     * @param images
     */
    public void deleteInBatch(Set<Image> images) {
        imageRepository.deleteInBatch(images);
    }
}
