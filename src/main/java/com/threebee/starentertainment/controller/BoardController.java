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
@RequestMapping("/board")
public class BoardController {

	/*
	 * 인증 처리 불요 (public) 
	 * @return 홈화면 
	 */
	@GetMapping({"/", "","/list"})
	public String list() {
		
		return "board/main";
	}
	
	/*
	 * 인증 처리 불요 (public) 
	 * @return 회원가입 페이지 
	 */
	@GetMapping("/write")
	public String boardWriteForm() {
		return "board/write-form";
	}
	
}
