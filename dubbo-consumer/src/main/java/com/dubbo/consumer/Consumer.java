package com.dubbo.consumer;

import com.dubbo.api.CompanyService;
import com.dubbo.api.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) {
        System.out.println("consumer start");

        while (true) {
            try {
                ClassPathXmlApplicationContext context =
                        new ClassPathXmlApplicationContext("consumer.xml");

                context.start();


                for (int i = 0; i <= 20; ++i) {
                    UserService userService = (UserService) context.getBean("userService");
                    System.out.println(userService.getUserInfo(1));
                }

                for (int i = 0; i <= 20; ++i) {
                    CompanyService companyService = (CompanyService) context.getBean("companyService");
                    System.out.println(companyService.getCompanyInfo());
                }

                break;
            } catch (com.alibaba.dubbo.rpc.RpcException e) {
                try {
                    Thread.sleep(1000);
                    System.out.println("retry...");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }

        }
    }
}
