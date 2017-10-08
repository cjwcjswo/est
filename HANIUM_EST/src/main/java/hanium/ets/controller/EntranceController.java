package hanium.ets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hanium.ets.dto.BoardDTO;
import hanium.ets.dto.MemberDTO;
import hanium.ets.dto.StageDTO;
import hanium.ets.service.BoardService;
import hanium.ets.service.MemberService;
import hanium.ets.service.NoticeService;
import hanium.ets.service.StageService;
import hanium.ets.util.Constants;

@Controller
@RequestMapping("/entrance")
public class EntranceController {
	@Autowired
	BoardService boardService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	StageService stageService;
	
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping("/home")
	private ModelAndView home(){
		List<BoardDTO> boardList = boardService.loadBoard();
		List<String> noticeList = noticeService.loadNotice();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/entrance/home");
		mv.addObject("boardList", boardList);
		mv.addObject("noticeList", noticeList);	
		return mv;
	}
	
	@RequestMapping("/insertBoard")
	private String insertBoard(Authentication auth, BoardDTO dto){
		String content = dto.getContent();
		content = content.replace("<", "&lt;");
		content = content.replace(">","&gt;");
		dto.setContent(content);
		String name = ((MemberDTO) auth.getPrincipal()).getName();
		dto.setName(name);
		boardService.insertBoard(dto);
		return "redirect:/entrance/home";
	}
	
	@RequestMapping("/rank")
	private ModelAndView rank(Authentication auth){
		String email = ((MemberDTO) auth.getPrincipal()).getEmail();
		ModelAndView mv = new ModelAndView();
		mv.addObject("myPoint", memberService.selectPoint(email));
		mv.addObject("rankList", memberService.selectRank());
		mv.setViewName("/entrance/rank");
		return mv;
		
	}
	
	@RequestMapping("/stage")
	private ModelAndView stage(Authentication auth){
		ModelAndView mv = new ModelAndView();
		String email = ((MemberDTO) auth.getPrincipal()).getEmail();
		for(int i=0; i < Constants.STAGE_NAME.length; i++){
			StageDTO stage =
			stageService.selectStage(new StageDTO(email, null, null, 0, Constants.STAGE_NAME[i]));
			mv.addObject(Constants.STAGE_NAME[i], stage);
			System.out.println(Constants.STAGE_NAME[i] + " : " + stage);
		}
		
		mv.setViewName("/entrance/stage");
		return mv;
		
	}
}
