package com.threebee.starentertainment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author 1000bang
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	/*
	 * 인증 처리 불요 (public) 
	 * @return 로그인 페이지 
	 */
	@GetMapping("/sign-in")
	public String signInForm() {
		
		return "user/signin-form";
	}
	
	/*
	 * 인증 처리 불요 (public) 
	 * @return 회원가입 페이지 
	 */
	@GetMapping("/sign-up")
	public String signUpForm() {
		return "user/signup-form";
	}
	
}
