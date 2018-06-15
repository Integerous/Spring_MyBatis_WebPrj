package com.ryemha.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ryemha.domain.BoardVO;
import com.ryemha.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value= "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model)throws Exception {
		
		logger.info("register get........");
	}
	
	@RequestMapping(value ="/register", method = RequestMethod.POST)
	public String registPOST(BoardVO board, /*Model model*/ RedirectAttributes rttr)throws Exception{
		
		logger.info("regist post........");
		logger.info(board.toString());
		
		service.regist(board);
		
		//model.addAttribute("result", "success");
		rttr.addFlashAttribute("msg", "success");
		//addFlashAttribute()는 브라우저까지 전송되기는 하지만 URI 상에는 보이지 않는 숨겨진 데이터의 형태로 전달된다.
		
		//return "/board/success";
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method= RequestMethod.GET)
	public void listAll(Model model)throws Exception{
		
		logger.info("show all list...............");
		model.addAttribute("list", service.listAll());
	}

}
