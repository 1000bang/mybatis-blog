package com.threebee.starentertainment.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.threebee.starentertainment.model.dto.common.Board;

@Mapper
public interface BoardDAO {
	
	public int insert(@Param("board") Board board, @Param("userId")int userId);
	public List<Board> findAll();
	public Board findById(int id);
	public int deleteById(int boardId);
	
	
}
