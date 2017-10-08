package hanium.ets.dao;

import java.util.List;

import hanium.ets.dto.BoardDTO;

public interface BoardDAO {
	/**
	 * 방명록 작성
	 * @param dto 방명록 DTO
	 * @return
	 */
	int insertBoard(BoardDTO dto);
	
	/**
	 * 방명록 목록 불러오기
	 * @return 방명록 목록
	 */
	List<BoardDTO> loadBoard();
}
