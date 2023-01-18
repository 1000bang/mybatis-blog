package com.threebee.starentertainment.api;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threebee.starentertainment.model.dto.common.Board;
import com.threebee.starentertainment.model.dto.common.User;
import com.threebee.starentertainment.model.dto.res.ResponseDTO;
import com.threebee.starentertainment.service.BoardService;
import com.threebee.starentertainment.utils.Script;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

	private final BoardService boardService;

	/*
	 * 보드 저장 Mime type : "application/json 파싱 전략 : object mapper 사
	 */
	@PostMapping("/save")
	public ResponseEntity<?> saveBoardProc(@RequestBody Board board, HttpSession reqSession) {

		User principal = (User) reqSession.getAttribute("principal");
		if (principal == null) {
			System.out.println("잘못된접근");
		}

		int result = boardService.save(board, principal.getId());

		ResponseDTO<Integer> dto = new ResponseDTO<Integer>(1, "글 등록 완료", result);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

	@DeleteMapping("/delete/{boardId}")
	public ResponseEntity<?> deleteBoard(@PathVariable int boardId, HttpSession session) {
		User principal = (User) session.getAttribute("principal");

		int result = -1;
		if (principal == null) {
			return ResponseEntity.status(HttpStatus.OK).body(Script.back("권한이 없습니다."));
		}
		Board boardDto = boardService.findById(boardId);
		if (principal.getUsername().equals(boardDto.getUsername())) {
			result = boardService.deleteBoard(boardId);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(Script.back("권한이 없습니다."));
		}
		if (result == 1) {
			ResponseEntity.status(HttpStatus.OK).body(Script.href("board/list", "게시글 정상 삭제되었습니다. "));
		}
		return ResponseEntity.status(HttpStatus.OK).body(Script.back("권한이 없습니다."));
	}

}
