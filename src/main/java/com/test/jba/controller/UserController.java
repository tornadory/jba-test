package com.test.jba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.jba.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String users(Model model){
		//System.out.print("userService.findAll num: " + userService.findAll().size());
		model.addAttribute("users", userService.findAll()); 
		//�����ã�������classic.jsp��  ���� ��users.jsp����û���������
		return "users";
	}
}
