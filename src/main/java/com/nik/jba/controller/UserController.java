package com.nik.jba.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nik.jba.entity.User;
import com.nik.jba.service.UserService;

@Controller
public class UserController {

	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	@Autowired
	private UserService userService;
	@RequestMapping("/users")
	public String users(Model m){
		m.addAttribute("users", userService.findAll());
		return "users";
	}
	
	@RequestMapping("/users/{id}")
	public String details(Model m, @PathVariable int id){
		System.out.println("Reaching..");
		m.addAttribute("user",userService.findOneWithBlog(id));
		return "users-details";
	}


	@RequestMapping("/register")
	public String register(){
		return "user-register";
	}
	
	
	@RequestMapping(value= "/register",method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user")User user ){
		userService.save(user);
		System.out.println(user.getName());
		return "user-register";
	}
	
	
	@RequestMapping(value="/account")
	public String myAccount(Model m,Principal p){
		System.out.println("principal object to get username"+p.getName());
		String username= p.getName();
		User u= userService.findBlogByUsername(username);
		m.addAttribute("user",u );
		return "user-details";
	}
	
	
}
