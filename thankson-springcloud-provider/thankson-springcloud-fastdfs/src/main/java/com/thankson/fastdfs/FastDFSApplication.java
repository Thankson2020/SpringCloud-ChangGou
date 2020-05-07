package com.thankson.fastdfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.thankson.fastdfs.dao"})
@ComponentScan(value = {"com.thankson.common.util","com.thankson.fastdfs"})
public class FastDFSApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastDFSApplication.class, args);
    }
}
