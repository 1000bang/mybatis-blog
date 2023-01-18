package com.threebee.starentertainment.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.threebee.starentertainment.model.dto.common.User;
import com.threebee.starentertainment.model.dto.res.SignInDTO;

@Mapper
public interface UserDAO {
	
	public int insert(User user);
	public List<User> findAll();
	public int deleteById(int id);
	public int update(User user);
	public User findByUsername(SignInDTO signInDTO);
	
	
}
