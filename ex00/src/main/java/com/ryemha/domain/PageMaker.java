package com.ryemha.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 10;
	private Criteria cri;
	
	
	//페이징 처리와 조회 화면으로 이동해서 사용되는 링크의 정보 수정
	//스프링의  UriComponents를 이용해서 페이징 처리에 필요한 데이터를 생성
	public String makeSearch(int page) {
		
		UriComponents uriComponents 
		= UriComponentsBuilder.newInstance()
			.queryParam("page", page)
			.queryParam("perPageNum", cri.getPerPageNum())
			.queryParam("searchType", ((SearchCriteria) cri).getSearchType())
			.queryParam("keyword", encoding(((SearchCriteria) cri).getKeyword())).build();
				
		return uriComponents.toUriString();
	}
	
	
	
	private Object encoding(String keyword) {
		
		if (keyword == null || keyword.trim().length() == 0) {
			
			return "";
		}
		try {
			return URLEncoder.encode(keyword, "UTF-8");
		}catch (UnsupportedEncodingException e) {
			return "";
		}
	}



	//현재 목록 페이지의 경우 모든 정보는 Criteria에 있기 때문에 MakeQuery() 메소드 추가
	public String makeQuery(int page) {
		
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();
		
		return uriComponents.toUriString();
	}
	
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}
	
	
	private void calcData() {
		
		endPage = (int)(Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		//삼항연산자
		prev = startPage == 1 ? false : true;
		
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}
	
	
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public Criteria getCri() {
		return cri;
	}
	
	
	
}
