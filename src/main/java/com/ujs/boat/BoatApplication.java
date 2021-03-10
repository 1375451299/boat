package com.ujs.boat;

import com.ujs.boat.Socket.ServerSocket1;
import com.ujs.boat.common.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@MapperScan(value="com.ujs.boat.Mapper")
@EnableSwagger2
@SpringBootApplication
@Import(SpringUtil.class)
public class BoatApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =SpringApplication.run(BoatApplication.class, args);
        applicationContext.getBean(ServerSocket1.class).ServerSocketDemo();

    }

}
