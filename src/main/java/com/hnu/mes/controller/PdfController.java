package com.hnu.mes.controller;

import com.hnu.mes.domain.Pdf;
import com.hnu.mes.domain.Result;
import com.hnu.mes.exception.EnumException;
import com.hnu.mes.exception.MesException;
import com.hnu.mes.service.PdfService;
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
 * @Date: Created in 13:14 2018/6/8
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/pdf")
public class PdfController {
    @Autowired
    private PdfService pdfService;

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/upload")
    public Result<Pdf> fileUpload(MultipartFile file) {

        if (file.isEmpty()) {
            return ResultUtil.error(new MesException(EnumException.UPLOAD_FAILED_FILE_EMPTY));
        }

        Pdf pdf = new Pdf();
        try {
            pdf.setData(file.getBytes());
            pdf = pdfService.save(pdf);
        } catch (IOException e) {
            return ResultUtil.error(new MesException(EnumException.UNKOWN_ERROR));
        }

        if(pdf != null){
            pdf.setData(null);
        }

        return ResultUtil.success(pdf);
    }

    /**
     * 下载pdf
     *
     * @param code
     * @param response
     * @return
     */
    @RequestMapping(value = "/download/{code}")
    public Result<Object> getImage(@PathVariable Long code, HttpServletResponse response) {
        Pdf pdf = pdfService.findOne(code);

        if (pdf == null) {
            return ResultUtil.error(new MesException(EnumException.PDF_NOT_EXIST));
        }

        byte[] bytes = pdf.getData();
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
        if (pdfService.findOne(code) == null) {
            return ResultUtil.error(new MesException(EnumException.IMAGE_NOT_EXIST));
        }

        pdfService.delete(code);
        return ResultUtil.success();
    }

    /**
     * 批量删除
     *
     * @param pdfs
     * @return
     */
    @PostMapping(value = "/deleteByBatchCode")
    public Result<Object> deleteByBatchCode(@RequestBody Set<Pdf> pdfs){
        pdfService.deleteInBatch(pdfs);
        return ResultUtil.success();
    }
}
