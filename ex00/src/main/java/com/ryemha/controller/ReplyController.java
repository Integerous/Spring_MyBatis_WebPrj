package com.ryemha.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ryemha.domain.ReplyVO;
import com.ryemha.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {

	@Inject
	private ReplyService service;
	
	@RequestMapping(value="", method= RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO vo) {
		
		ResponseEntity<String> entity = null;
		try {
			service.addReply(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") Integer bno){
	
		ResponseEntity<List<ReplyVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.listReply(bno), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	// REST 방식에서  update 작업은 PUT, PATCH 방식을 이용해서 처리한다.
	// 전체 데이터를 수정하는 경우 = PUT 사용
	// 일부 데이터를 수정하는 경우 = PATCH 사용
	@RequestMapping(value="/{rno}",
			method = { RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("rno") Integer rno,
											@RequestBody ReplyVO vo) {
		
		ResponseEntity<String> entity = null;
		
		try {
			vo.setRno(rno);
			service.modifyReply(vo);
			
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(
					e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	@RequestMapping(value="/{rno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("rno") Integer rno)	{
		
		ResponseEntity<String> entity = null;
		
		try {
			service.removeReply(rno);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	
}








