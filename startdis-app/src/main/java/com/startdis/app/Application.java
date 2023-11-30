package com.startdis.app;

import com.startdis.comm.feign.annotation.EnableStartdisFeignClients;
import com.startdis.comm.swagger.annotation.EnableStartdisSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Enablestartdistem
//@EnableLogRecord
@EnableDiscoveryClient
@EnableStartdisSwagger2
@EnableStartdisFeignClients
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.startdis")
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class Application {
    
    
    public static void main(String[] args) {
        
        SpringApplication.run(Application.class, args);
        
        System.out.println("(♥◠‿◠)ﾉﾞ  Startdis Cloud App 启动成功   ლ(´ڡ`ლ)ﾞ ");
        
    }

}
