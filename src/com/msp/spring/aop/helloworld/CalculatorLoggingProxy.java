package com.msp.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorLoggingProxy {
	
	private Calculator target;
	
	public CalculatorLoggingProxy(Calculator target) {
		this.target = target;
	}
	
	public Calculator getLoggingProxy() {
		Calculator proxy = null;
		
		//�����������һ��������������� 
		ClassLoader loader = target.getClass().getClassLoader();
		
		//�����������ͣ�����������Щ����
		Class [] interfaces = new Class[]{Calculator.class};
		
		//�����ô���������еķ���ʱ����ִ�еĴ���
		
		InvocationHandler h = new InvocationHandler() {
			
			/*
			 * proxy:���ڷ��ص��Ǹ��������һ������£���invoke�����ж���ʹ�á�
			 * method:���ڵ��õķ���
			 * args:���÷���ʱ������Ĳ���
			 * */
			
			@Override
			public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
				
				String methodName = arg1.getName();
				System.out.println("The method "+ methodName + "begin with"+ Arrays.asList(arg2) );
				Object result = arg1.invoke(target, arg2);
				System.out.println("The method "+ methodName + "end with"+ result );
				return result;//�������return null,���׳��쳣
			}
		};
		
		proxy = (Calculator)Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
		
	}

}










