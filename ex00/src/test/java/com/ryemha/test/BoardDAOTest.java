package com.ryemha.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryemha.domain.BoardVO;
import com.ryemha.domain.MemberVO;
import com.ryemha.persistence.BoardDAO;
import com.ryemha.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {

	@Inject
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	public void testCreate() throws Exception{
		
		BoardVO board = new BoardVO();
		board.setTitle("제목 테스트 입니다.");
		board.setContent("내용 테스트 입니다.");
		board.setWriter("user000");
		dao.create(board);
	}
	
	@Test
	public void testRead() throws Exception{
		
		logger.info(dao.read(2).toString());
	}
	
	@Test
	public void testUpdate() throws Exception{
		
		BoardVO board = new BoardVO();
		board.setBno(2);
		board.setTitle("수정된 글제목 테스트");
		board.setContent("수정된 글 내용 테슽으");
		dao.update(board);
	}
	
	@Test
	public void testDelete() throws Exception{
		
		dao.delete(1);
	}
	
}
