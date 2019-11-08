package com.hushuai.sakura;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class_name: SakuraApplication
 * @Exception:
 * @Describe: 启动类
 * @Author: shuaihu2
 * @Creat_date: 2019/11/1 14:23
 **/
@RestController
@MapperScan("com.hushuai.sakura.mapper")
@SpringBootApplication
public class SakuraApplication {

    public static void main(String[] args) {
        SpringApplication.run(SakuraApplication.class, args);
    }

//    @RequestMapping("/")
//    public String start() {
//        return "index";
//    }
}
