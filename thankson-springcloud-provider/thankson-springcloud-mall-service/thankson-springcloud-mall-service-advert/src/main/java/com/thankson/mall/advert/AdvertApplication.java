package com.thankson.mall.advert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.thankson.mall.advert.dao"})
@EnableFeignClients
public class AdvertApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvertApplication.class);
    }
}