package hanium.ets.dao;

import hanium.ets.dto.MemberDTO;
import hanium.ets.dto.StageDTO;

public interface StageDAO {
	/**
	 * �������� �ʱ�ȭ
	 * @param dto ��������
	 * @return
	 */
	int initStage(StageDTO dto);
	
	/**
	 * �������� ���� ��������
	 * @param dto ������ ��������
	 * @return �������� ����
	 */
	StageDTO selectStage(StageDTO dto);
	
	/**
	 * �������� ������Ʈ
	 * @param dto
	 * @return
	 */
	int updateStage(StageDTO dto);
	
	
	/**
	 * �ƿ���Ʈ �ι�° �������� ��� ����
	 * @param dto
	 * @return
	 */
	MemberDTO outlastTwoSelectMember(MemberDTO dto);
}
