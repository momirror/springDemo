package com.msp.spring.aop.helloworld;

public class Main {

	public static void main(String[] args) {
		
		Calculator target = new CalculatorImp();
		Calculator proxy = new CalculatorLoggingProxy(target).getLoggingProxy();
		
		int result = proxy.add(3, 3);
		System.out.println(result);
		
		result = proxy.mul(3, 4);
		System.out.println(result);

	}

}
