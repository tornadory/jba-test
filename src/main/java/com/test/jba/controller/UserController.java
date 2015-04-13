package com.test.jba.controller;

import java.security.Principal;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.jba.entity.Blog;
import com.test.jba.entity.User;
import com.test.jba.service.BlogService;
import com.test.jba.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	@ModelAttribute("user")
	public User constructUser(){
		return new User();
	}
	
	@ModelAttribute("blog")
	public Blog constructBlog(){
		return new Blog();
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
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result){
		if(result.hasErrors()){
			return "user-register";
		}
		userService.save(user);
		return "redirect:/register.html?success=true";
	}
 
	@RequestMapping("/account")
	public String account(Model model, Principal principal){
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithBlogs(name));
		return "user-detail";
	}
	
	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String doAddBlog(Model model, @Valid @ModelAttribute("blog") Blog blog, BindingResult result, Principal principal){
		if(result.hasErrors()){
			return account(model, principal);
		}
		String name = principal.getName();
		blogService.save(blog, name);
		return "redirect:/account.html";
	}
	
	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable int id){
		Blog blog = blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/account.html";
	}
	
	@RequestMapping("/users/remove/{id}")
	public String removeUser(@PathVariable int id){
		userService.delete(id);
		return "redirect:/users.html";
	}
}
