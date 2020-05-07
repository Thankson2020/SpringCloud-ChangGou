package com.thankson.fastdfs.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.InputStream;
import java.util.Date;

@Table(name = "tb_file_message")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileMessage {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 文件名称
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 文件类型
     */
    @Column(name = "file_type")
    @NotBlank(message = "文件类型不能为空")
    private String fileType;

    /**
     * 文件扩展名
     */
    @Column(name = "file_extension")
    private String fileExtension;

    /**
     * 文件大小
     */
    @Column(name = "file_size")
    private Long fileSize;

    /**
     * 文件路径
     */
    @Column(name = "file_path")
    private String filePath;

    /**
     * 文件描述
     */
    @Column(name = "description")
    @NotBlank(message = "文件描述不能为空")
    private String description;

    /**
     * 归属系统标识
     */
    @Column(name = "sys_flag")
    @NotBlank(message = "系统标识不能为空")
    private String sysFlag;

    /**
     * 上传时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 上传人
     */
    @Column(name = "uploader")
    private String uploader;

    /**
     * 删除标识
     */
    @Column(name = "del_flag")
    private String delFlag;

}
