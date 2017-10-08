package hanium.ets.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hanium.ets.dto.MemberDTO;
import hanium.ets.dto.PointDTO;
import hanium.ets.dto.StageDTO;
import hanium.ets.service.MemberService;
import hanium.ets.service.NoticeService;
import hanium.ets.service.StageService;
import hanium.ets.util.Constants;

@Controller
@RequestMapping("/outlast")
public class OutlastController {
	@Autowired
	MemberService memberService;

	@Autowired
	StageService stageService;

	@Autowired
	NoticeService noticeService;

	@RequestMapping("/")
	public String tutorial(Authentication auth) {
		String email = ((MemberDTO) auth.getPrincipal()).getEmail();
		String name = ((MemberDTO) auth.getPrincipal()).getName();
		StageDTO dto = stageService.selectStage(new StageDTO(email, null, null, 0, Constants.STAGE_NAME[1]));
		// 처음 시작일 경우
		if (dto == null) {
			Calendar calendar = Calendar.getInstance();
			java.util.Date date = calendar.getTime();
			String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
			System.out.println("처음 시작");
			noticeService.insertNotice(name + "님이 " + today + "에 " + Constants.STAGE_NAME[1] + " 스테이지를 처음으로 도전하셨습니다!");
			stageService.initStage(new StageDTO(email, null, null, 1, Constants.STAGE_NAME[1]));
			return "redirect:/outlast/" + Constants.OUTLAST_STAGE[0];
		} else {
			// 중간 시작일 경우
			if (dto.getEndDay() == null) {
				System.out.println(dto.getStage() - 1 + "부터 시작");
				return "redirect:/outlast/" + Constants.OUTLAST_STAGE[dto.getStage() - 1];
			} else { // 이미 끝낸 경우
				System.out.println("이미 클리어했습니다.");
				return "redirect:/outlast/" + Constants.OUTLAST_STAGE[0];
			}
		}
	}

	/**
	 * 처음 스테이지
	 */
	@RequestMapping("/EditCookie")
	public String intoTheDarkness(HttpServletResponse response) {
		response.addCookie(new Cookie("level", "nothing"));
		return "/outlast/" + Constants.OUTLAST_STAGE[0];
	}

	/**
	 * 두번째 스테이지로
	 */
	@RequestMapping("/levelcheck")
	public String levelCheck(Authentication auth, HttpServletRequest request) {
		String level = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if(name.equals("level")) level = cookie.getValue();
			}
		}
		if(level == null || (!level.equals("ok"))){
			return "/outlast/fail"; 
		}else {
			String email = ((MemberDTO) auth.getPrincipal()).getEmail();
			StageDTO dto = stageService.selectStage(new StageDTO(email, null, null, 0, Constants.STAGE_NAME[1]));
			
			//처음 clear했을경우
			if(dto.getStage() < 2){
				stageService.updateStage(new StageDTO(email, null, null, 2, Constants.STAGE_NAME[1]));
				memberService.updatePoint(new PointDTO(email, null, 300));

			}
			return "redirect:/outlast/" + Constants.OUTLAST_STAGE[1];
		}
	}
	
	@RequestMapping("/ReadMessage")
	public String readMessage(){
		return "/outlast/"+Constants.OUTLAST_STAGE[1];
	}
	
	/**
	 * 두번쨰 스테이지 답안 제출
	 */
	@RequestMapping("/two")
	public String two(Authentication auth, MemberDTO dto){
		System.out.println(dto);
		MemberDTO answer = stageService.outlastTwoSelectMember(dto);
		if(answer == null){
			return "/outlast/fail"; 
		}else{
			System.out.println(answer);
			return "";
		}
	}
}
