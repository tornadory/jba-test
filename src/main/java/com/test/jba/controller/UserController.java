package com.test.jba.controller;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.jba.entity.User;
import com.test.jba.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	@RequestMapping("/users")
	public String users(Model model){
		//System.out.print("userService.findAll num: " + userService.findAll().size());
		model.addAttribute("users", userService.findAll()); 
		//起作用，但仅在classic.jsp中  。。 在users.jsp里面没有这个变量
		return "users";
		//return "/WEB-INF/jsp/users.jsp";
		//return "/WEB-INF/jsp/classic.jsp"; //OK
	}
	
	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable int id){
		System.out.print("id: "+id);
		//model.addAttribute("user", userService.findOne(id));
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user-detail";
		//return "/WEB-INF/jsp/user-detail-new.jsp"; //OK
		//return "/WEB-INF/jsp/user-detail.jsp";
	}
	
	@RequestMapping("/register")
	public String showRegister(){
		return "user-register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user){
		userService.save(user);
		return "user-register";
	}
}
