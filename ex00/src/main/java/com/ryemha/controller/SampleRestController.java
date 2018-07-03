package com.ryemha.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryemha.domain.SampleRestVO;

@RestController //JSP와 같은 뷰를 만들어 내지 않는 대신 데이터 자체를 반환. 이 때 주로 사용되는 것은 단순문자열, JSON, XML 등.
				// @RestController 애노테이션이 사용된 클래스의 모든 메소드는 @ResponseBody가 없어도 동일하게 동작
@RequestMapping("/sample")
public class SampleRestController {

	
	// 1.문자열은 'text/html' 타입으로 데이터가 전송된다.
	@RequestMapping("/hello")
	public String sayHello() {
		
		return "Hello World";  
	}
	
	// 2.객체를 JSON으로 반환
	@RequestMapping("/sendVO")
	public SampleRestVO sendVO() {
		
		SampleRestVO vo = new SampleRestVO();
		vo.setFirstName("정수");
		vo.setLastName("한");
		vo.setMno(123);
		
		return vo; 
	}
	
	
	
	// 3.컬렉션 타입의 객체 반환
	@RequestMapping("/sendList")
	public List<SampleRestVO> sendList(){
		
		List<SampleRestVO> list = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			SampleRestVO vo = new SampleRestVO();
			vo.setFirstName("정은");
			vo.setLastName("박");
			vo.setMno(i);
			list.add(vo);
		}
		
		return list; 
	
	}
	
	// 4.Map 객체 반환
	@RequestMapping("/sendMap")
	public Map<Integer, SampleRestVO> sendMap()	{
		
		Map<Integer, SampleRestVO> map = new HashMap<>();
		
		for(int i=0; i<10; i++) {
			SampleRestVO vo = new SampleRestVO();
			vo.setFirstName("하루");
			vo.setLastName("박");
			vo.setMno(i);
			map.put(i, vo);
		}
		return map; 
	}
	
	
	// 5.ResponseEntity 타입
	// 스프링에서 제공하는 ResponseEntity 타입은 개발자가 직접 결과 데이터 + HTTP의
	// 상태 코드를 직접 제어할 수 있는 클래스이다.
	// ResponseEnity를 이용하면 개발자는 404나 500같은 HTTP 상태 코드를
	// 전송하고 싶은 데이터와 함께 전송할 수 있기 때문에 좀 더 세밀한 제어가 필요한 경우에 사용 가능. 
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth(){
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	// 6.결과 데이터와 HTTP 상태코드 함께 사용
	// 이 방식은 주로 호출한 쪽으로 에러의 원인 메세지를 전송할 때 사용
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<SampleRestVO>> sendListNot(){
		
		List<SampleRestVO> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			SampleRestVO vo = new SampleRestVO();
			vo.setFirstName("한");
			vo.setLastName("정수");
			vo.setMno(i);
			list.add(vo);
		}
		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}
	
}









