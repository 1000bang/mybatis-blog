package com.threebee.starentertainment.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.threebee.starentertainment.model.dto.common.User;

@Mapper
public interface UserDAO {
	
	public int insert(User user);
	public List<User> findAll();
	public int deleteById(int id);
	public int update(User user);
	
	
	
}
