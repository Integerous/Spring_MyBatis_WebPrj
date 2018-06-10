package com.ryemha.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryemha.domain.ProductVO;

@Controller
public class SampleController5 {


	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON() {
			//@ResponseBody는 리턴타입이 HTTP의 응답메시지로 전송
		
		ProductVO vo = new ProductVO("샘플상품", 30000);
		
		return vo;
		
	}
	

	
}
