package com.threebee.starentertainment.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class AddFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("Add 필터 초기화 ");
	}
	
	
	/**
	 *  전후처리 request, response 가 필터를 거칠 때 수행되는 메서드가
	 *  chain ,doFilter 기점으로 나누어진다. 
	 */
	
	@Override
	public void doFilter(ServletRequest request, 
						ServletResponse response, 
						FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
	
		String requestURI = req.getRequestURI();
		log.info("=====request("+ requestURI + ") 필터 =========");
		chain.doFilter(request, response);
		log.info("=====response("+ res.getContentType() + ") 필터 =========");
		
	}
	
	@Override
	public void destroy() {
		log.info("Add 필터 소멸 ");
	}

}
