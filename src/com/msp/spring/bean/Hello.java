package com.msp.spring.bean;

public class Hello {
	private String name;
	private Integer age;
	
  
     public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Hello [name=" + name + ", age=" + age + "]";
	}


	public void hello(){
    	 System.out.println("hello " + this.name);
     }

	
}
