package hanium.ets.dao;

import java.util.List;

import hanium.ets.dto.BoardDTO;

public interface BoardDAO {
	/**
	 * ���� �ۼ�
	 * @param dto ���� DTO
	 * @return
	 */
	int insertBoard(BoardDTO dto);
	
	/**
	 * ���� ��� �ҷ�����
	 * @return ���� ���
	 */
	List<BoardDTO> loadBoard();
}
