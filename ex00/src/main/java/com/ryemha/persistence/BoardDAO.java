package com.ryemha.persistence;

import java.util.List;

import com.ryemha.domain.BoardVO;
import com.ryemha.domain.Criteria;
import com.ryemha.domain.SearchCriteria;

public interface BoardDAO {

	public void create(BoardVO vo)throws Exception;
	
	public BoardVO read(Integer bno)throws Exception;
	
	public void update(BoardVO vo)throws Exception;
	
	public void delete(Integer bno)throws Exception;
	
	public List<BoardVO> listAll()throws Exception;
	
	//페이징 처리를 위해
	public List<BoardVO> listPage(int page)throws Exception;
	
	// listCriteria()는 Criteria 객체를 파라미터로 전달받고,
	// 필요한 getPageStart()와 getPerPageNum() 메소드를 호출한 결과를 사용하게 된다.
	public List<BoardVO> listCriteria(Criteria cri)throws Exception;
	
	
	// totalCount 반환 할 수 있도록
	public int countPaging(Criteria cri)throws Exception;
	
	
	//검색과 페이징 둘 다 처리하기 위해서 SearchCriteria를 파라미터로 받음
	public List<BoardVO> listSearch(SearchCriteria cri)throws Exception;
	
	public int listSearchCount(SearchCriteria cri)throws Exception;
	
	
	
	
}
