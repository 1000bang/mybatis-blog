package com.threebee.starentertainment.intercepter;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.threebee.starentertainment.model.dto.common.User;
import com.threebee.starentertainment.model.dto.res.ResponseDTO;

public class LoginIntercepter implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("================");
		System.out.println(request.getRequestURI());
		System.out.println("================");
		
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		User principal = (User)session.getAttribute("principal");
		if(principal == null ) {
			if(uri.contains("api")) {
				//다르게 응답
				response.setContentType("application/json; charset=utf-8");
				PrintWriter out = response.getWriter();
				ResponseDTO<String> resDto = new ResponseDTO<>(-1, "잘못된 접근입니다.", "권한이 없습니다. ");
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writeValueAsString(resDto);  // json 형식을 가진 문자열로 변환됨 
				out.println(json);
				out.flush();
			
			}
			response.sendRedirect("/user/sign-in");
		}

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
}
