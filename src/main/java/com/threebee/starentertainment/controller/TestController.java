package com.threebee.starentertainment.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threebee.starentertainment.model.dto.common.User;
import com.threebee.starentertainment.service.UserService;
import com.threebee.starentertainment.utils.Script;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {

	private final UserService userService;
	
	@ResponseBody
	@GetMapping("/req-test")
	public String reqTest() {
		return Script.back("인증권한이 없습니다.");
	}
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return Script.href("/board/list", "boardlist");
	}
	
	@GetMapping("/user-list")
	@ResponseBody
	public List<User> userList() {
		
		List<User> userList =  userService.findUserAll();
		
		return userList;
	}
	
	@PostMapping("/user-save")
	@ResponseBody
	public int insertUserTest(@RequestBody User user) {
		int resultRow = userService.saveUser(user);
		return resultRow;
	}
	
	@DeleteMapping("/user-delete/{id}")
	@ResponseBody
	public int deleteUserTest(@PathVariable int id) {
		int resultRow = userService.deleteUser(id);
		return resultRow;
	}
	
	@PutMapping("/user-update")
	@ResponseBody
	public int updateUserTest(@RequestBody User user) {
		int resultRow = userService.updateUser(user);
		return resultRow;
	}
	
	
}
