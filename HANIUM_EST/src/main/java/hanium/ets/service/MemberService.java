package hanium.ets.service;

import java.util.List;

import hanium.ets.dto.MemberDTO;
import hanium.ets.dto.PointDTO;

public interface MemberService {
	/**
	 * ȸ�� ����
	 * @param dto ��� dto
	 * @return �����ͺ��̽� ��� ��
	 */
	int insertMember(MemberDTO dto);
	
	/**
	 * �α���
	 * @param dto ��� dto
	 * @return �����ͺ��̽� ��� ����
	 */
	MemberDTO selectMember(MemberDTO dto);
	
	/**
	 * �� ����Ʈ ��������
	 * @param email �� �̸����ּ�
	 * @return ����Ʈ����
	 */
	PointDTO selectPoint(String email);
	/**
	 * ����Ʈ ������Ʈ
	 * @param dto ����Ʈ
	 * @return
	 */
	int updatePoint(PointDTO dto);
	/**
	 * ����Ʈ��ŷ TOP 50
	 * @return ����Ʈ����Ʈ
	 */
	List<PointDTO> selectRank();

}
