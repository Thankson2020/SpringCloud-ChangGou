package com.thankson.fastdfs.service.impl;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.thankson.common.util.business.Result;
import com.thankson.fastdfs.dao.FileMessageDao;
import com.thankson.fastdfs.pojo.FileMessage;
import com.thankson.fastdfs.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMessageDao fileMessageDao;

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Value(value = "${com.thankson.springcloud.FastDFS.pathPrefix}")
    private String pathPrefix;

    @Override
    public Result<Object> uploadFile(InputStream inputStream, FileMessage fileMessage) {
        try {
            //上传文件至FastDFS
            StorePath storePath = fastFileStorageClient.uploadFile(inputStream, fileMessage.getFileSize(), fileMessage.getFileExtension(), null);
            if (storePath == null) {
                return new Result<>(false, 500, "文件上传失败");
            }
            //文件访问路径
            String path = pathPrefix + "/" + storePath.getFullPath();
            fileMessage.setFilePath(path);
            //保存文件信息
            int i = fileMessageDao.insertSelective(fileMessage);
            if (i < 1) {
                return new Result<>(false, 500, "保存文件信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false, 500, "上传文件时发生异常");
        }

        return new Result<>(true, 200, "上传成功", fileMessage);
    }
}
