package com.thankson.mall.advert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.thankson.mall.advert.dao"})
public class AdvertApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvertApplication.class);
    }
}