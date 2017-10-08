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
		// ó�� ������ ���
		if (dto == null) {
			Calendar calendar = Calendar.getInstance();
			java.util.Date date = calendar.getTime();
			String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
			System.out.println("ó�� ����");
			noticeService.insertNotice(name + "���� " + today + "�� " + Constants.STAGE_NAME[1] + " ���������� ó������ �����ϼ̽��ϴ�!");
			stageService.initStage(new StageDTO(email, null, null, 1, Constants.STAGE_NAME[1]));
			return "redirect:/outlast/" + Constants.OUTLAST_STAGE[0];
		} else {
			// �߰� ������ ���
			if (dto.getEndDay() == null) {
				System.out.println(dto.getStage() - 1 + "���� ����");
				return "redirect:/outlast/" + Constants.OUTLAST_STAGE[dto.getStage() - 1];
			} else { // �̹� ���� ���
				System.out.println("�̹� Ŭ�����߽��ϴ�.");
				return "redirect:/outlast/" + Constants.OUTLAST_STAGE[0];
			}
		}
	}

	/**
	 * ó�� ��������
	 */
	@RequestMapping("/EditCookie")
	public String intoTheDarkness(HttpServletResponse response) {
		response.addCookie(new Cookie("level", "nothing"));
		return "/outlast/" + Constants.OUTLAST_STAGE[0];
	}

	/**
	 * �ι�° ����������
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
			
			//ó�� clear�������
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
	 * �ι��� �������� ��� ����
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
