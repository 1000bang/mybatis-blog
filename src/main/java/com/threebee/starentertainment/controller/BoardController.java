package com.threebee.starentertainment.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.threebee.starentertainment.model.dto.common.Board;
import com.threebee.starentertainment.model.dto.common.User;
import com.threebee.starentertainment.service.BoardService;

import lombok.RequiredArgsConstructor;
/**
 * 
 * @author 1000bang
 *
 */
@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	/*
	 * 인증 처리 불요 (public) 
	 * @return 홈화면 
	 */
	@GetMapping({"/", "","/board/list"})
	public String list(Model model) {
		List<Board> list = boardService.selectAll();
		model.addAttribute("boardList", list);
		return "board/main";
	}
	
	/*
	 * 인증 처리 필요 !!auth 
	 * @return 글작성 페이지 
	 */
	@GetMapping("/auth/board/write")
	public String boardWriteForm() {
		return "board/write-form";
	}
	
	
	/*
	 * 인증 x 
	 * @return 디테일 페이지 
	 */
	@GetMapping("/board/detail/{id}")
	public String boardDetailForm(@PathVariable(name= "id") int id, Model model, HttpSession reqSession) {
		Board board = boardService.findById(id);
		User principal = (User)reqSession.getAttribute("principal");
		boolean isWriter = false;
		if(principal != null) {
			if(principal.getUsername().equals(board.getUsername())) {
				isWriter = true;
			}
		}
	
		model.addAttribute("board", board);
		model.addAttribute("isWriter", isWriter);
		return "board/detail";
	}
	
	/*
	 * 인증 처리 auth
	 * @return 게시글 수정화면  
	 */
	@GetMapping("/auth/board/modify/{id}")
	public String modify(@PathVariable int id, Model model) {
		Board board = boardService.findById(id);
		model.addAttribute("boardData", board);
		return "board/update-form";
	}
	
}
