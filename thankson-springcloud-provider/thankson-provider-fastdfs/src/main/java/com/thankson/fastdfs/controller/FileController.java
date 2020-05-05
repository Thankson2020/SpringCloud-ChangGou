package com.thankson.fastdfs.controller;

import com.thankson.common.util.business.Result;
import com.thankson.fastdfs.pojo.FileMessage;
import com.thankson.fastdfs.service.FileService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * 文件上传
 *
 * @author Thankson
 * @date 2020年5月5日
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 上传文件
     *
     * @param file        文件
     * @param fileMessage 文件信息
     * @author Thankson
     * @date 2020年5月5日
     */
    @PostMapping(value = "/uploadFile")
    public Result<Object> uploadFile(@RequestPart MultipartFile file, @RequestPart @Validated FileMessage fileMessage) {
        fileMessage.setFileName(FilenameUtils.getBaseName(file.getOriginalFilename()));
        fileMessage.setCreateDate(new Date());
        fileMessage.setFileExtension(FilenameUtils.getExtension(file.getOriginalFilename()));
        fileMessage.setFileSize(file.getSize());
        fileMessage.setUploader("test");
        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return new Result<>(false, 500, "上传文件流获取失败");
        }
        return fileService.uploadFile(inputStream,fileMessage);
    }
}
