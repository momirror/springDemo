package com.msp.spring.aop.imp;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(* com.msp.spring.aop.imp.Calculator.*(int, int))")
	public void declareJoinPointExpression(){};
	
	@Before("execution(* com.msp.spring.aop.imp.Calculator.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" begins with" + args);
	}
	
	@After("execution(* com.msp.spring.aop.imp.Calculator.*(int, int))")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" ends");
	}
	
	@AfterReturning(value="execution(* com.msp.spring.aop.imp.Calculator.*(int, int))",returning="result")
	public void afterReturningMethod(JoinPoint joinPoint,Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" return with "+ result);
	}
	
	@AfterThrowing(value="execution(* com.msp.spring.aop.imp.Calculator.*(int, int))",throwing="ex")
	public void afterThrowMethod(JoinPoint joinPoint,Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs exception: "+ ex);
	}
	
	@Around("declareJoinPointExpression()")
	public Object aroundMethoud(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Object result = null;
		try {
//			前置通知
			System.out.println("around method begin");
			result = joinPoint.proceed();
//			返回通知
			System.out.println("around method end");
		} catch (Exception e) {
//			异常通知
			System.out.println("around method occurs exception: "+e);
		}
//		后置通知
		System.out.println("around method ends");
		return result;
	}
}
