package hanium.ets.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
@RequestMapping("/tutorial")
public class TutorialController {
	@Autowired
	MemberService memberService;
	
	@Autowired
	StageService stageService;
	
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping("/")
	public String tutorial(Authentication auth){
		String email = ((MemberDTO) auth.getPrincipal()).getEmail();
		String name = ((MemberDTO) auth.getPrincipal()).getName();
		StageDTO dto = stageService.selectStage(new StageDTO(email, null, null, 0, Constants.STAGE_NAME[0]));
		// 처음 시작일 경우
		if(dto == null){
			Calendar calendar = Calendar.getInstance();
            java.util.Date date = calendar.getTime();
            String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
			System.out.println("처음 시작");
			noticeService.insertNotice(name+"님이 " + today + "에 " + Constants.STAGE_NAME
					[0] +" 스테이지를 처음으로 도전하셨습니다!");
			stageService.initStage(new StageDTO(email, null, null, 1, Constants.STAGE_NAME[0]));
			return "redirect:/tutorial/"+Constants.TUTORIAL_STAGE[0];
		}else{
			// 중간 시작일 경우
			if(dto.getEndDay() == null){
				System.out.println(dto.getStage()-1+"부터 시작");
				return "redirect:/tutorial/"+Constants.TUTORIAL_STAGE[dto.getStage()-1];
			}else{ // 이미 끝낸 경우
				System.out.println("이미 클리어했습니다.");
				return "redirect:/tutorial/"+Constants.TUTORIAL_STAGE[0];
			}
		}
	}
	
	/**
	 * 처음 스테이지
	 */
	@RequestMapping("/IntoTheDarkness")
	public String intoTheDarkness(){
		return "/tutorial/IntoTheDarkness";
	}
	
	/**
	 * 2번째 스테이지
	 */
	@RequestMapping("/HorrorHospital")
	public String horrorHospital(Authentication auth){
		String email = ((MemberDTO) auth.getPrincipal()).getEmail();
		StageDTO dto = stageService.selectStage(new StageDTO(email, null, null, 0, Constants.STAGE_NAME[0]));
		
		//처음 clear했을 경우
		if(dto.getStage() < 2){
			// stage를 2로 상승시키고 포인트를 상승
			stageService.updateStage(new StageDTO(email, null, null, 2, Constants.STAGE_NAME[0]));
			memberService.updatePoint(new PointDTO(email, null, 100));
		}
		return "/tutorial/"+Constants.TUTORIAL_STAGE[1];
	}
	
	/**
	 * 2번째 스테이지 정답 제출
	 */
	@RequestMapping("/two")
	public String two(Authentication auth, String answer){
		if(answer == null || answer.trim().equals("") || !answer.equals("77581925123")){
			return "/tutorial/fail";
		}
		else{ // 정답일 경우
			String email = ((MemberDTO) auth.getPrincipal()).getEmail();
			StageDTO dto = stageService.selectStage(new StageDTO(email, null, null, 0, Constants.STAGE_NAME[0]));
			
			//처음 clear했을경우
			if(dto.getStage() < 3){
				stageService.updateStage(new StageDTO(email, null, null, 3, Constants.STAGE_NAME[0]));
				memberService.updatePoint(new PointDTO(email, null, 200));
			}
			return "redirect:/tutorial/"+Constants.TUTORIAL_STAGE[2];
		}
	}
	
	/**
	 * 스테이지 3
	 * @return
	 */
	@RequestMapping("/LockedDoor")
	public String lockedDoor(){
		return "/tutorial/"+Constants.TUTORIAL_STAGE[2];
	}
	
	/**
	 * 3번째 스테이지 정답 제출
	 */
	@RequestMapping("/three")
	public String three(Authentication auth, String id, String pw){
		if((id == null || pw == null) || !(id.trim().equals("1234") && pw.trim().equals("1234"))){
			return "/tutorial/fail";
		}
		else{ // 정답일 경우
			String email = ((MemberDTO) auth.getPrincipal()).getEmail();
			StageDTO dto = stageService.selectStage(new StageDTO(email, null, null, 0, Constants.STAGE_NAME[0]));
			
			//처음 clear했을경우
			if(dto.getStage() < 4){
				stageService.updateStage(new StageDTO(email, null, null, 4, Constants.STAGE_NAME[0]));
				memberService.updatePoint(new PointDTO(email, null, 250));
			}
			return "redirect:/tutorial/"+Constants.TUTORIAL_STAGE[3];
		}
	}
	
	@RequestMapping("/DarkLaptop")
	public String darkLaptop(){
		return "/tutorial/"+Constants.TUTORIAL_STAGE[3];
	}
	
	@RequestMapping("/four")
	public String four(Authentication auth, String answer){
		if(answer == null){
			return "/tutorial/fail";
		}else{
			StringBuilder sb = new StringBuilder("");
			for(int i=0; i<answer.length(); i++){
				sb.append((char)(answer.charAt(i)-3));
			}
			String realAnswer = sb.toString();
			if(realAnswer.equals("doctor/;")){
				String email = ((MemberDTO) auth.getPrincipal()).getEmail();
				StageDTO dto = stageService.selectStage(new StageDTO(email, null, null, 0, Constants.STAGE_NAME[0]));
				
				//처음 clear했을경우
				if(dto.getStage() < 5){
					Calendar calendar = Calendar.getInstance();
					String name = ((MemberDTO) auth.getPrincipal()).getName();
		            java.util.Date date = calendar.getTime();
		            String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		            noticeService.insertNotice(name+"님이 " + today + "에 " + Constants.STAGE_NAME
							[0] +" 스테이지를 <font color='red'>클리어</font>하셨습니다!");
	
					stageService.updateStage(new StageDTO(email, null, "OK", 5, Constants.STAGE_NAME[0]));
					memberService.updatePoint(new PointDTO(email, null, 200));
				}
				return "/tutorial/"+Constants.TUTORIAL_STAGE[4];
			}else{
				return "/tutorial/fail";
			}
			
		}
	}
}

