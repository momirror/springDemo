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
		
		//代理对象由哪一个加载器负责加载 
		ClassLoader loader = target.getClass().getClassLoader();
		
		//代理对象的类型，即其中有哪些方法
		Class [] interfaces = new Class[]{Calculator.class};
		
		//当调用代理对象其中的方法时，该执行的代码
		
		InvocationHandler h = new InvocationHandler() {
			
			/*
			 * proxy:正在返回的那个代理对象，一般情况下，在invoke方法中都不使用。
			 * method:正在调用的方法
			 * args:调用方法时，传入的参数
			 * */
			
			@Override
			public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
				
				String methodName = arg1.getName();
				System.out.println("The method "+ methodName + "begin with"+ Arrays.asList(arg2) );
				Object result = arg1.invoke(target, arg2);
				System.out.println("The method "+ methodName + "end with"+ result );
				return result;//这里如果return null,会抛出异常
			}
		};
		
		proxy = (Calculator)Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
		
	}

}










