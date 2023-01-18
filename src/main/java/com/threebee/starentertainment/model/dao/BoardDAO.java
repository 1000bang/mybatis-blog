package com.threebee.starentertainment.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.threebee.starentertainment.model.dto.common.Board;

@Mapper
public interface BoardDAO {
	
	public int insert(Board board);
	public List<Board> findAll();
	
	
}
