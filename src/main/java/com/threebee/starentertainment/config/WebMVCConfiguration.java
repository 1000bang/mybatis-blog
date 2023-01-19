package com.threebee.starentertainment.config;

import javax.servlet.FilterRegistration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.threebee.starentertainment.intercepter.LoginIntercepter;

@Configuration
public class WebMVCConfiguration implements WebMvcConfigurer {
	// 필터 등
	@Bean
	public FilterRegistrationBean<?> filterBean() {

		FilterRegistrationBean<AddFilter> registrationBean = new FilterRegistrationBean(new AddFilter());

		registrationBean.setOrder(Integer.MIN_VALUE); // 필터 여러개 적용시 순번
		registrationBean.addUrlPatterns("/api/*"); // 어떤 url 패턴이 요청왔을 때만 적용하도록 설정 가능
		return registrationBean;
	}

	// 인터셉터 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginIntercepter())
		.addPathPatterns("/auth/**", "/api/**");
		//WebMvcConfigurer.super.addInterceptors(registry);
	}

}
