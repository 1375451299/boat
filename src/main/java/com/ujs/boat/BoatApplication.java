package com.ujs.boat;

import com.ujs.boat.Service.ServerSocket1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoatApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoatApplication.class, args);
        ServerSocket1 serverSocket1=new ServerSocket1();
        serverSocket1.ServerSocketDemo();
    }

}
