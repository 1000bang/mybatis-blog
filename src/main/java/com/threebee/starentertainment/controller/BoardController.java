package com.threebee.starentertainment.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.threebee.starentertainment.model.dto.common.Board;
import com.threebee.starentertainment.service.BoardService;

import lombok.RequiredArgsConstructor;
/**
 * 
 * @author 1000bang
 *
 */
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	/*
	 * 인증 처리 불요 (public) 
	 * @return 홈화면 
	 */
	@GetMapping({"/", "","/list"})
	public String list(Model model) {
		List<Board> list = boardService.selectAll();
		model.addAttribute("boardList", list);
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
