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
		// ó�� ������ ���
		if(dto == null){
			Calendar calendar = Calendar.getInstance();
            java.util.Date date = calendar.getTime();
            String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
			System.out.println("ó�� ����");
			noticeService.insertNotice(name+"���� " + today + "�� " + Constants.STAGE_NAME
					[0] +" ���������� ó������ �����ϼ̽��ϴ�!");
			stageService.initStage(new StageDTO(email, null, null, 1, Constants.STAGE_NAME[0]));
			return "redirect:/tutorial/"+Constants.TUTORIAL_STAGE[0];
		}else{
			// �߰� ������ ���
			if(dto.getEndDay() == null){
				System.out.println(dto.getStage()-1+"���� ����");
				return "redirect:/tutorial/"+Constants.TUTORIAL_STAGE[dto.getStage()-1];
			}else{ // �̹� ���� ���
				System.out.println("�̹� Ŭ�����߽��ϴ�.");
				return "redirect:/tutorial/"+Constants.TUTORIAL_STAGE[0];
			}
		}
	}
	
	/**
	 * ó�� ��������
	 */
	@RequestMapping("/IntoTheDarkness")
	public String intoTheDarkness(){
		return "/tutorial/IntoTheDarkness";
	}
	
	/**
	 * 2��° ��������
	 */
	@RequestMapping("/HorrorHospital")
	public String horrorHospital(Authentication auth){
		String email = ((MemberDTO) auth.getPrincipal()).getEmail();
		StageDTO dto = stageService.selectStage(new StageDTO(email, null, null, 0, Constants.STAGE_NAME[0]));
		
		//ó�� clear���� ���
		if(dto.getStage() < 2){
			// stage�� 2�� ��½�Ű�� ����Ʈ�� ���
			stageService.updateStage(new StageDTO(email, null, null, 2, Constants.STAGE_NAME[0]));
			memberService.updatePoint(new PointDTO(email, null, 100));
		}
		return "/tutorial/"+Constants.TUTORIAL_STAGE[1];
	}
	
	/**
	 * 2��° �������� ���� ����
	 */
	@RequestMapping("/two")
	public String two(Authentication auth, String answer){
		if(answer == null || answer.trim().equals("") || !answer.equals("77581925123")){
			return "/tutorial/fail";
		}
		else{ // ������ ���
			String email = ((MemberDTO) auth.getPrincipal()).getEmail();
			StageDTO dto = stageService.selectStage(new StageDTO(email, null, null, 0, Constants.STAGE_NAME[0]));
			
			//ó�� clear�������
			if(dto.getStage() < 3){
				stageService.updateStage(new StageDTO(email, null, null, 3, Constants.STAGE_NAME[0]));
				memberService.updatePoint(new PointDTO(email, null, 200));
			}
			return "redirect:/tutorial/"+Constants.TUTORIAL_STAGE[2];
		}
	}
	
	/**
	 * �������� 3
	 * @return
	 */
	@RequestMapping("/LockedDoor")
	public String lockedDoor(){
		return "/tutorial/"+Constants.TUTORIAL_STAGE[2];
	}
	
	/**
	 * 3��° �������� ���� ����
	 */
	@RequestMapping("/three")
	public String three(Authentication auth, String id, String pw){
		if((id == null || pw == null) || !(id.trim().equals("1234") && pw.trim().equals("1234"))){
			return "/tutorial/fail";
		}
		else{ // ������ ���
			String email = ((MemberDTO) auth.getPrincipal()).getEmail();
			StageDTO dto = stageService.selectStage(new StageDTO(email, null, null, 0, Constants.STAGE_NAME[0]));
			
			//ó�� clear�������
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
				
				//ó�� clear�������
				if(dto.getStage() < 5){
					Calendar calendar = Calendar.getInstance();
					String name = ((MemberDTO) auth.getPrincipal()).getName();
		            java.util.Date date = calendar.getTime();
		            String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		            noticeService.insertNotice(name+"���� " + today + "�� " + Constants.STAGE_NAME
							[0] +" ���������� <font color='red'>Ŭ����</font>�ϼ̽��ϴ�!");
	
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

