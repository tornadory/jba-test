package com.test.jba.annotation;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.jba.repository.UserRepository;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if(userRepository == null){
			return true;
		}
		return userRepository.findByName(username) == null;
	}

}
