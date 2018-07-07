package com.ryemha.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ryemha.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "org.ryemha.mapper.ReplyMapper";
	
	
	@Override
	public List<ReplyVO> list(Integer bno) throws Exception {

		return sqlSession.selectList(namespace + ".list", bno) ;
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
	
		sqlSession.insert(namespace + ".create", vo);
		
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		
		sqlSession.update(namespace + ".update", vo);
		
	}

	@Override
	public void delete(Integer rno) throws Exception {
		
		sqlSession.delete(namespace + ".delete", rno);
		
	}

}
