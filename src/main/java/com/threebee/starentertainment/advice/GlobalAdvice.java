package com.threebee.starentertainment.advice;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.threebee.starentertainment.model.dto.common.SiteError;

@ControllerAdvice
public class GlobalAdvice {

	@ExceptionHandler(value = Exception.class)
	public void exception(Exception e) {
		System.out.println("================");
		System.out.println(e.getClass().getName());
		System.out.println(e.getMessage());
		System.out.println("================");
	}

	// 1단계 동일 예외 같은 메세지
	@ExceptionHandler(value = DuplicateKeyException.class)
	public ResponseEntity<?> duplicateKeyException(DuplicateKeyException e) {
		System.out.println(e.getMessage());
		return new ResponseEntity<>("동일한 이름이 존재합니다. ", HttpStatus.BAD_REQUEST);
	}

	// 2단계 사용자정의 예외처리
//	@ExceptionHandler(value = UniqueUserNameException.class)
//	public ResponseEntity<?> duplicateKeyException(UniqueUserNameException e) {
//
//		return new ResponseEntity<>(e.getDefaultMessage(), HttpStatus.BAD_REQUEST);
//	}

	// 3단계 사용자정의 예외처리
	@ExceptionHandler(value = UniqueUserNameException.class)
	public String duplicateKeyException(UniqueUserNameException e, Model model) {
		SiteError error = new SiteError();
		error.setField(e.getField());
		error.setInvalidValue(e.getInvalidValue());
		error.setMessage(e.getDefaultMessage());
		model.addAttribute("isError", true);
		model.addAttribute("error", error);
		
		return "user/signup-form";
	}

}
