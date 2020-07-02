package com.example.dmdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DmDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmDemoApplication.class, args);
        log.info("DmDemoApplication 启动成功！");
    }

}
