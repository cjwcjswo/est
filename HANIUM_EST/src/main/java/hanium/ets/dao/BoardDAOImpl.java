package hanium.ets.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hanium.ets.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertBoard(BoardDTO dto) {
		return sqlSession.insert("boardMapper.insertBoard", dto);
	}

	@Override
	public List<BoardDTO> loadBoard() {
		return sqlSession.selectList("boardMapper.loadBoard");
	}
	
	
}
