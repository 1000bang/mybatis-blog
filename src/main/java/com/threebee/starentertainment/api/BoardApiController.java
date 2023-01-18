package com.threebee.starentertainment.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threebee.starentertainment.model.dto.common.Board;
import com.threebee.starentertainment.model.dto.res.ResponseDTO;
import com.threebee.starentertainment.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

	private final BoardService boardService;
	
	/*
	 * 보드 저장 
	 * Mime type : "application/json
	 * 파싱 전략 : object mapper 사 
	 */
	@PostMapping("/save")
	public ResponseEntity<?> saveBoardProc(@RequestBody Board board) {
		
		int result = boardService.save(board);
		
		
		ResponseDTO<Integer> dto = new ResponseDTO<Integer>(1, "글 등록 완료", result);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
		
	}
	
}
