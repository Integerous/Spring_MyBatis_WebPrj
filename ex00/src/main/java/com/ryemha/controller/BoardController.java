package com.ryemha.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ryemha.domain.BoardVO;
import com.ryemha.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	
	//등록 폼
	@RequestMapping(value= "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model)throws Exception {
		
		logger.info("register get........");
	}
	//등록
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
	
	// 목록
	@RequestMapping(value="/listAll", method= RequestMethod.GET)
	public void listAll(Model model)throws Exception{
		
		logger.info("show all list...............");
		model.addAttribute("list", service.listAll());
	}
	
	// 조회
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception{
		
		model.addAttribute(service.read(bno));
		//addAttribute()에 이름없이 데이터를 넣으면 자동으로 클래스 명을 사용하되 첫글자만 소문자로 바뀐다.
		// 여기서 들어가는 데이터는 BoardVO 클래스의 객체이므로, 'boardVO'라고 저장된다.
	}
	
	// 삭제
	@RequestMapping(value="remove", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
		
		service.remove(bno);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listAll";	
	}
	
	// 수정폼
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception{
		
		model.addAttribute(service.read(bno));
	}
	
	// 수정
	@RequestMapping(value= "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr)throws Exception{
		
		logger.info("mod post.........");
		
		service.modify(board);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listAll";
	}

}
















