package hanium.ets.dao;

import java.util.List;

import hanium.ets.dto.AuthorityDTO;
import hanium.ets.dto.MemberDTO;
import hanium.ets.dto.PointDTO;

public interface MemberDAO {
	/**
	 * ȸ�� ����
	 * @param dto ��� dto
	 * @return �����ͺ��̽� ��� ��
	 */
	int insertMember(MemberDTO dto);
	
	/**
	 * ���̵� �ߺ� üũ
	 * @param dto ��� dto
	 * @return �����ͺ��̽� ��� ��
	 */
	MemberDTO checkId(MemberDTO dto);
	
	/**
	 * ���� ����
	 * @param dto ���� dto
	 * @return �����ͺ��̽� ��� ��
	 */
	int insertAuth(AuthorityDTO dto);
	
	/**
	 * ����Ʈ �ʱ�ȭ
	 * @param dto ����Ʈ
	 * @return
	 */
	int initPoint(PointDTO dto);
	
	/**
	 * ����Ʈ ����
	 * @param dto ����Ʈ
	 * @return
	 */
	int updatePoint(PointDTO dto);
	
	/**
	 * ���� �ҷ�����
	 * @param email �ҷ��� �̸���
	 * @return �����ͺ��̽� ��� ��
	 */
	List<AuthorityDTO> selectAuth(String email);
	
	/**
	 * �� ����Ʈ ��������
	 * @param email �� �̸����ּ�
	 * @return ����Ʈ����
	 */
	PointDTO selectPoint(String email);
	
	/**
	 * ����Ʈ��ŷ TOP 50
	 * @return ����Ʈ����Ʈ
	 */
	List<PointDTO> selectRank();
	
}
