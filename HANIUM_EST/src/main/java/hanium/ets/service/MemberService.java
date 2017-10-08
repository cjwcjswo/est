package hanium.ets.service;

import java.util.List;

import hanium.ets.dto.MemberDTO;
import hanium.ets.dto.PointDTO;

public interface MemberService {
	/**
	 * 회원 가입
	 * @param dto 멤버 dto
	 * @return 데이터베이스 결과 값
	 */
	int insertMember(MemberDTO dto);
	
	/**
	 * 로그인
	 * @param dto 멤버 dto
	 * @return 데이터베이스 멤버 정보
	 */
	MemberDTO selectMember(MemberDTO dto);
	
	/**
	 * 내 포인트 가져오기
	 * @param email 내 이메일주소
	 * @return 포인트정보
	 */
	PointDTO selectPoint(String email);
	/**
	 * 포인트 업데이트
	 * @param dto 포인트
	 * @return
	 */
	int updatePoint(PointDTO dto);
	/**
	 * 포인트랭킹 TOP 50
	 * @return 포인트리스트
	 */
	List<PointDTO> selectRank();

}
