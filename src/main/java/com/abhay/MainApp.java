package com.abhay;


import com.abhay.config.AppConfig;
import com.abhay.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp
{
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService service =
                context.getBean(EmployeeService.class);


        service.addEmployee(1, "Abhay", 50000.0);
        service.addEmployee(2, "Vishal", 60000.0);

        service.listEmployees().forEach(System.out::println);
    }

    }


