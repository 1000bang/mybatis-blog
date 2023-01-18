package com.threebee.starentertainment.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.threebee.starentertainment.model.dto.common.User;
import com.threebee.starentertainment.model.dto.res.SignInDTO;
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

	//DI 처리 
	private final UserService userservice;
	private final HttpSession session;
	
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
	
	/* 
	 * 인증 불필요
	 * 로그인 처리 
	 * mime type - form(application/x-www-form-urlencoded)
	 * parsing stg - object mapper 
	 * @return 메인화면
	 */
	@PostMapping("/signin-proc")
	public String signInProc(SignInDTO signInDTO, Model model) {
		User principal = userservice.findByUsername(signInDTO);
		if(principal == null) {
			model.addAttribute("isNotSignIn", true);
			return "user/signin-form";
		}
		//세션은 키, 벨류로 데이터 저장 가능 
		session.setAttribute("principal", principal);
		// 이렇게하면 패스워드 정보노출의 우려가 있음 
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
	
}
