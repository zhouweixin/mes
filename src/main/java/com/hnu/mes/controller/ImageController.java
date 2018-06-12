package com.hnu.mes.controller;

import com.hnu.mes.domain.Image;
import com.hnu.mes.domain.Result;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.ImageService;
import com.hnu.mes.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

/**
 * @Author: zhouweixin
 * @Description:
 * @Date: Created in 18:25 2018/6/6
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/upload")
    public Result<Image> fileUpload(MultipartFile file) {

        if (file.isEmpty()) {
            return ResultUtil.error(new MesException(EnumException.UPLOAD_FAILED_FILE_EMPTY));
        }

        Image image = new Image();
        try {
            image.setData(file.getBytes());
            image = imageService.save(image);
        } catch (IOException e) {
            return ResultUtil.error(new MesException(EnumException.UNKOWN_ERROR));
        }

        if(image != null){
            image.setData(null);
        }

        return ResultUtil.success(image);
    }

    /**
     * 查询图片
     *
     * @param code
     * @param response
     * @return
     */
    @RequestMapping(value = "/{code}")
    public Result<Object> getImage(@PathVariable Long code, HttpServletResponse response) {
        Image image = imageService.findOne(code);

        if (image == null) {
            return ResultUtil.error(new MesException(EnumException.IMAGE_NOT_EXIST));
        }

        byte[] bytes = image.getData();
        try {
            OutputStream os = response.getOutputStream();
            os.write(bytes, 0, bytes.length);
            os.flush();
        } catch (IOException e) {
            return ResultUtil.error(new MesException(EnumException.UNKOWN_ERROR));
        }

        return ResultUtil.success();
    }

    /**
     * 通过主键删除
     *
     * @param code
     * @return
     */
    @RequestMapping(value = "/deleteByCode")
    public Result<Object> deleteByCode(Long code) {
        if (imageService.findOne(code) == null) {
            return ResultUtil.error(new MesException(EnumException.IMAGE_NOT_EXIST));
        }

        imageService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 批量删除
     *
     * @param images
     * @return
     */
    @PostMapping(value = "/deleteByBatchCode")
    public Result<Object> deleteByBatchCode(@RequestBody Set<Image> images){
        imageService.deleteInBatch(images);
        return ResultUtil.success();
    }
}
