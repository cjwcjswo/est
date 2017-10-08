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
		MemberDTO member = memberDAO.checkId(dto); // ���̵� �ߺ�üũ

		// ���̵� �ߺ��� ���
		if (member != null) {
			result = -1;
			return result;
		}
		String encPassword = passwordEncoder.encode(dto.getPassword()); // �н�����
																		// ��ȣȭ
		dto.setPassword(encPassword);
		result = memberDAO.insertMember(dto);
		
		String email = dto.getEmail();
		String name = dto.getName();
		//���� ����
		memberDAO.insertAuth(new AuthorityDTO(email, "ROLE_MEMBER"));
		//����Ʈ �ʱ�ȭ
		memberDAO.initPoint(new PointDTO(email, name, 0));
		return result;
	}

	@Override
	public MemberDTO selectMember(MemberDTO dto) {
		MemberDTO member = memberDAO.checkId(dto); // ȸ�� �˻�
		if(member == null) return null; // �˻� ����� ���ٸ�
		//��й�ȣ�� ��ġ���� �ʴٸ�
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
