package com.dubbo.consumer;

import com.dubbo.api.CompanyService;
import com.dubbo.api.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("consumer.xml");

        context.start();
        System.out.println("consumer start");
        for (int i = 0; i <= 20; ++i) {
            UserService userService = (UserService) context.getBean("userService");
            System.out.println("consumer");
            System.out.println(userService.getUserInfo(1));
        }

        for (int i = 0; i <= 20; ++i) {
            CompanyService companyService = (CompanyService) context.getBean("companyService");
            System.out.println("consumer");
            System.out.println(companyService.getCompanyInfo());
        }
    }
}
