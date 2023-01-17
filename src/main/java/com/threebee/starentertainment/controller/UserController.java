package com.threebee.starentertainment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.threebee.starentertainment.model.dto.common.User;
/**
 * 
 * @author 1000bang
 *
 */
import com.threebee.starentertainment.service.UserService;

import lombok.RequiredArgsConstructor;
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	
	private final UserService userservice;
	
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
	
	/* 
	 * 회원가입 처리 
	 * mime type - form(application/x-www-form-urlencoded)
	 * parsing stg - object mapper 
	 * @return 메인화면
	 */
	@PostMapping("/signup-proc")
	public String signUpProc(User user) {
		userservice.saveUser(user);
		return "redirect:/";
	}
	
}
