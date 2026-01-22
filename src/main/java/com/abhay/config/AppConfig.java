package com.abhay.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.abhay")
@EnableAspectJAutoProxy
public class AppConfig {
}
