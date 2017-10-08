package hanium.ets.dao;

import hanium.ets.dto.MemberDTO;
import hanium.ets.dto.StageDTO;

public interface StageDAO {
	/**
	 * 스테이지 초기화
	 * @param dto 스테이지
	 * @return
	 */
	int initStage(StageDTO dto);
	
	/**
	 * 스테이지 정보 가져오기
	 * @param dto 유저의 스테이지
	 * @return 스테이지 정보
	 */
	StageDTO selectStage(StageDTO dto);
	
	/**
	 * 스테이지 업데이트
	 * @param dto
	 * @return
	 */
	int updateStage(StageDTO dto);
	
	
	/**
	 * 아웃라스트 두번째 스테이지 멤버 대조
	 * @param dto
	 * @return
	 */
	MemberDTO outlastTwoSelectMember(MemberDTO dto);
}
