package com.msp.spring.aop.imp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-imp.xml");
		Calculator calculator = ctx.getBean(Calculator.class);
		int result = calculator.add(3, 8);
		System.out.println("result: "+result);
		
		result = calculator.mul(2, 7);
		System.out.println("result: "+result);
		
		result = calculator.div(2, 3);
		System.out.println("result: "+result);

	}

}
