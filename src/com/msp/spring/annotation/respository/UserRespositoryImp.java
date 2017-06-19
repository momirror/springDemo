package com.msp.spring.annotation.respository;

import org.springframework.stereotype.Repository;

@Repository("UserRepository1")
public class UserRespositoryImp implements UserRepository {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserRepository save");
	}

}
