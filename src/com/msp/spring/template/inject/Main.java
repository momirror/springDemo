package com.msp.spring.template.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("template-inject.xml");
		UserService userService = (UserService)ctx.getBean("userService");
		userService.add();
	}
}
