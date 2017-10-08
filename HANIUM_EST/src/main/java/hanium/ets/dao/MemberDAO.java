package hanium.ets.dao;

import java.util.List;

import hanium.ets.dto.AuthorityDTO;
import hanium.ets.dto.MemberDTO;
import hanium.ets.dto.PointDTO;

public interface MemberDAO {
	/**
	 * 회원 가입
	 * @param dto 멤버 dto
	 * @return 데이터베이스 결과 값
	 */
	int insertMember(MemberDTO dto);
	
	/**
	 * 아이디 중복 체크
	 * @param dto 멤버 dto
	 * @return 데이터베이스 결과 값
	 */
	MemberDTO checkId(MemberDTO dto);
	
	/**
	 * 권한 삽입
	 * @param dto 권한 dto
	 * @return 데이터베이스 결과 값
	 */
	int insertAuth(AuthorityDTO dto);
	
	/**
	 * 포인트 초기화
	 * @param dto 포인트
	 * @return
	 */
	int initPoint(PointDTO dto);
	
	/**
	 * 포인트 갱신
	 * @param dto 포인트
	 * @return
	 */
	int updatePoint(PointDTO dto);
	
	/**
	 * 권한 불러오기
	 * @param email 불러올 이메일
	 * @return 데이터베이스 결과 값
	 */
	List<AuthorityDTO> selectAuth(String email);
	
	/**
	 * 내 포인트 가져오기
	 * @param email 내 이메일주소
	 * @return 포인트정보
	 */
	PointDTO selectPoint(String email);
	
	/**
	 * 포인트랭킹 TOP 50
	 * @return 포인트리스트
	 */
	List<PointDTO> selectRank();
	
}
