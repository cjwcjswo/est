package hanium.ets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hanium.ets.dao.MemberDAO;
import hanium.ets.dto.AuthorityDTO;
import hanium.ets.dto.MemberDTO;
import hanium.ets.dto.PointDTO;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO memberDAO;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public int insertMember(MemberDTO dto) {
		int result = 0;
		MemberDTO member = memberDAO.checkId(dto); // 아이디 중복체크

		// 아이디 중복일 경우
		if (member != null) {
			result = -1;
			return result;
		}
		String encPassword = passwordEncoder.encode(dto.getPassword()); // 패스워드
																		// 암호화
		dto.setPassword(encPassword);
		result = memberDAO.insertMember(dto);
		
		String email = dto.getEmail();
		String name = dto.getName();
		//권한 삽입
		memberDAO.insertAuth(new AuthorityDTO(email, "ROLE_MEMBER"));
		//포인트 초기화
		memberDAO.initPoint(new PointDTO(email, name, 0));
		return result;
	}

	@Override
	public MemberDTO selectMember(MemberDTO dto) {
		MemberDTO member = memberDAO.checkId(dto); // 회원 검색
		if(member == null) return null; // 검색 결과가 없다면
		//비밀번호가 일치하지 않다면
		if(!passwordEncoder.matches(dto.getPassword(), member.getPassword())){
			return null;
		}
		return member;
	}

	@Override
	public PointDTO selectPoint(String email) {
		return memberDAO.selectPoint(email);
	}

	@Override
	public List<PointDTO> selectRank() {
		return memberDAO.selectRank();
	}

	@Override
	public int updatePoint(PointDTO dto) {
		return memberDAO.updatePoint(dto);
	}


}
