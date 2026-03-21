package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * 后端服务启动入口。
 */
public class MyProjectBackendApplication {

    /**
     * Spring Boot 主函数，负责引导整个应用上下文。
     */
    public static void main(String[] args) {
        SpringApplication.run(MyProjectBackendApplication.class, args);
    }

}
