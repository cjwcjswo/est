package hanium.ets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hanium.ets.dto.MemberDTO;
import hanium.ets.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService memberService;

	@RequestMapping("/signup")
	public String signup() {
		return "/member/signup";
	}

	@RequestMapping("/insert")
	public String insert(MemberDTO dto) throws Exception {
		int result = memberService.insertMember(dto);
		if (result > 0) {
			return "redirect:/";
		} else {
			throw new Exception("EMAIL has already existed!");
		}
	}
}
