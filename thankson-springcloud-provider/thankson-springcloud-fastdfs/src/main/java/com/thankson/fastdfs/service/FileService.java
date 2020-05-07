package com.thankson.fastdfs.service;

import com.thankson.common.util.business.Result;
import com.thankson.fastdfs.pojo.FileMessage;

import java.io.InputStream;

public interface FileService {

    /**
     * 上传文件至FastDFS
     *
     * @param fileMessage 文件信息
     * @author Thankson
     * @date 2020年5月5日
     */
    Result<Object> uploadFile(InputStream inputStream, FileMessage fileMessage);

}
