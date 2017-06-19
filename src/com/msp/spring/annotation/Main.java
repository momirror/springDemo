package com.msp.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.msp.spring.annotation.component.TestObject;
import com.msp.spring.annotation.component.TestStudent;
import com.msp.spring.annotation.controller.UserController;
import com.msp.spring.annotation.respository.UserRespositoryImp;
import com.msp.spring.annotation.service.UserService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-annotation.xml");
		
		TestObject obj = (TestObject)ctx.getBean("testObject");
		obj.test();
		
		UserService service = (UserService) ctx.getBean("userService");
		service.add();
		
		UserController controller = (UserController) ctx.getBean("userController");
		controller.execute();
		
		UserRespositoryImp respo = (UserRespositoryImp) ctx.getBean("UserRepository1");
		respo.save();
		
		TestStudent stu = (TestStudent) ctx.getBean("testStudent");
		stu.say();
	}
	
}
