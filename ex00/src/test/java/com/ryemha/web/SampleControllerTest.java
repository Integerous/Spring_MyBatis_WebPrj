package com.ryemha.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //이것이 기존의 스프링과 스프링 MVC를 테스트 하는데 있어서 가장 큰 차이
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SampleControllerTest {

	
	private static final Logger logger = LoggerFactory.getLogger(SampleControllerTest.class);
	
	
	@Inject
	private WebApplicationContext wac;
	
	//MockMvc는 브라우저에서 요청과 응답을 의미하는 객체로 간주
	private MockMvc mockMvc;
	
	@Before //매번  테스트를 진행할 때마다 가상의 요청과 응답을 처리하기 위해서 set()에서는 @Before 로 처리되어 매번 실행 전에 MockMvc객체를 만든다
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.info("setup............");
	}
	
	
	@Test
	public void testDoA() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
	}
}
