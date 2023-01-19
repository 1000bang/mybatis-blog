package com.threebee.starentertainment.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threebee.starentertainment.model.dao.BoardDAO;
import com.threebee.starentertainment.model.dto.common.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardDAO boardDAO;
	
	/*
	 * 보드 저장 
	 * TODO 유저 아이디 추가해야함 
	 */
	@Transactional
	public int save(Board board, int id) {
		return boardDAO.insert(board, id);
	}
	
	/*
	 * 보드 출력 findall  
	 */
	@Transactional
	public List<Board> selectAll() {
		return boardDAO.findAll();
	}

	/*
	 * 보드 출력 보드아이디로 찾기   
	 */
	public Board findById(int id) {
	 return boardDAO.findById(id);
	}

	/*
	 * 보드 삭제 보드아이디로 삭제   
	 */
	public int deleteBoard(int boardId) {
		return boardDAO.deleteById(boardId);
	}
	
	/*
	 * 보드 수정     
	 */
	public int modifyBoard(Board board) {
		return boardDAO.modifyById(board);
	}
}
