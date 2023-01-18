package com.threebee.starentertainment.service;

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
	public int save(Board board) {
		return boardDAO.insert(board);
	}
}
