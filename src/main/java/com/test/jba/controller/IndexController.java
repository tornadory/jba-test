package com.test.jba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(){
		System.out.print("try to go to index");
		//return "/WEB-INF/jsp/index.jsp";
		return "index";
	}
}
