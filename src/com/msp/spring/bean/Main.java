package com.msp.spring.bean;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args){
		//Hello hello = new Hello();
	//	hello.setName("msp");
		//hello.hello();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Hello hello = (Hello)ctx.getBean("hello");
		hello.hello();
		
		System.out.println(hello.toString());
	}
}
