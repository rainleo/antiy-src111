package com.antiy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Demo class
 *
 * @author liuyu
 * @date 2018/11/01
 */

@SpringBootApplication
@EnableTransactionManagement
@MapperScan({ "com.antiy.dao.**" })
@ComponentScan({"com.antiy.**"})
@EnableAsync
public class SrcApplication {


    public static void main(String[] args) {
        SpringApplication.run(SrcApplication.class, args);
    }
}
