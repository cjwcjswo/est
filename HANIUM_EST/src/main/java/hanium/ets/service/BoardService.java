package hanium.ets.service;

import java.util.List;

import hanium.ets.dto.BoardDTO;

public interface BoardService {
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
