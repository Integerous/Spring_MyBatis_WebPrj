package com.ryemha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice // 이 클래스의 객체가 컨트롤러에서 발생하는  Exception을 전문적으로 처리하는 클래스라는 것을 명시
// @ControllerAdvice 클래스의 메소드는 발생한  Exception 객체의 타입만을 파라미터로 사용할 수 있고,
// 일반 Controller와 같이 Model을 파라미터로 사용하는 것은 지원하지 않기 때문에 
//	직접 ModelAndView 타입을 사용하는 형태로 작성해야 한다.

// ModelAndView는 하나의 객체에  Model 데이터와 View 처리를 동시에 할 수 있는 객체이다
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception ex) {
			
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("/error_common");
		modelAndView.addObject("exception",ex);
		
		return modelAndView;
	}
	
}
