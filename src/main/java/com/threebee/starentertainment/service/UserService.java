package com.threebee.starentertainment.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threebee.starentertainment.model.dao.UserDAO;
import com.threebee.starentertainment.model.dto.common.User;

@Service
public class UserService {

	private final UserDAO userDAO;
	
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Transactional
	public List<User> findUserAll(){
		return userDAO.findAll();
	}

	@Transactional
	public int saveUser(User user) {
		int result = userDAO.insert(user);
		return result;
	}

	public int deleteUser(int id) {
		int result = userDAO.deleteById(id);
		return result;
	}
	
	public int updateUser(User user) {
		return userDAO.update(user);
	}
	
}
