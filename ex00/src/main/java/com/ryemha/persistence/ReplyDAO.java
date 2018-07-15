package com.ryemha.persistence;

import java.util.List;

import com.ryemha.domain.Criteria;
import com.ryemha.domain.ReplyVO;

public interface ReplyDAO {

	public List<ReplyVO> list(Integer bno) throws Exception;
	
	public void create(ReplyVO vo) throws Exception;
	
	public void update(ReplyVO vo) throws Exception;
	
	public void delete(Integer rno) throws Exception;
	
	
	//페이징 처리를 위한
	public List<ReplyVO> listPage(
			Integer bno, Criteria cri) throws Exception;
	
	public int count(Integer bno) throws Exception;
}
