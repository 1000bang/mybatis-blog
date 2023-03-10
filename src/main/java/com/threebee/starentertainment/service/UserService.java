package com.threebee.starentertainment.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threebee.starentertainment.advice.UniqueUserNameException;
import com.threebee.starentertainment.model.dao.UserDAO;
import com.threebee.starentertainment.model.dto.common.User;
import com.threebee.starentertainment.model.dto.res.SignInDTO;

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

	
	/**
	 * Timestamp - 나노초까지 컨트롤 가능
	 * Date - 밀리 세컨즈 까지 처리 가능 
	 * 회원가입 처리 
	 */
	@Transactional
	public int saveUser(User user) {
		
		user.setRole("USER");
		user.setCreateDate(new Timestamp(System.currentTimeMillis()));
		int result = 0;
		try {
			result = userDAO.insert(user);
		} catch (Exception e) {
			String msg = "중복된 이름이 존재합니다.";
			String field = "username";
			String invalidValue = user.getUsername();
			
					
					
			throw new UniqueUserNameException(msg, field, invalidValue);
		}
		
		
		return result;
	}
	
	@Transactional
	public User findByUsername(SignInDTO signInDTO) {
		//사용자 이름으로 찾는 기능 분리
		// 찾았다면 넘겨받은 비밀번호 조회된 비밀번호 같은 지 확인해서 처리 
		
		User user = userDAO.findByUsername(signInDTO); //이름만 확인
		if(user == null) {
			return null; // 아이디 없을 때 
		}else if(user.getPassword().equals(signInDTO.getPassword())) {
			return user;
		}else {
			return null; //비번 틀렸을 때 
		}
	}
	
	
	@Transactional
	public int deleteUser(int id) {
		int result = userDAO.deleteById(id);
		return result;
	}
	@Transactional
	public int updateUser(User user) {
		return userDAO.update(user);
	}
	
}
