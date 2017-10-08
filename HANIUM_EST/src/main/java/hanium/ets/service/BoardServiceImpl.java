package hanium.ets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hanium.ets.dao.BoardDAO;
import hanium.ets.dto.BoardDTO;
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public int insertBoard(BoardDTO dto) {
		return boardDAO.insertBoard(dto);
	}

	@Override
	public List<BoardDTO> loadBoard() {
		return boardDAO.loadBoard();
	}
	

}
