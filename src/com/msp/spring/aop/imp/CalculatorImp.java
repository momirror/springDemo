package com.msp.spring.aop.imp;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImp implements Calculator {

	@Override
	public int add(int i, int j) {
		// TODO Auto-generated method stub
		return i + j;
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		return i - j;
	}

	@Override
	public int mul(int i, int j) {
		// TODO Auto-generated method stub
		return i * j;
	}

	@Override
	public int div(int i, int j) {
		// TODO Auto-generated method stub
		return i / j;
	}

}
