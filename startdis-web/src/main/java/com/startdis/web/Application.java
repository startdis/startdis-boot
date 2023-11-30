package com.startdis.web;

import com.startdis.comm.feign.annotation.EnableStartdisFeignClients;
import com.startdis.comm.swagger.annotation.EnableStartdisSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * 系统服务启动程序
 */
 //@EnableLogRecord
@EnableDiscoveryClient
@EnableStartdisSwagger2
@EnableStartdisFeignClients
@SpringBootApplication(scanBasePackages = "com.startdis")
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class Application {

    public static void main(String[] args) {

        System.setProperty("cfg.env","local");

        SpringApplication.run(Application.class, args);

        System.out.println("(♥◠‿◠)ﾉﾞ  Startdis Boot Web Startup Completed!   ლ(´ڡ`ლ)ﾞ ");

    }

}
