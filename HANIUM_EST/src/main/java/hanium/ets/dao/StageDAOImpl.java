package hanium.ets.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hanium.ets.dto.MemberDTO;
import hanium.ets.dto.StageDTO;

@Repository
public class StageDAOImpl implements StageDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public int initStage(StageDTO dto) {
		return sqlSession.insert("stageMapper.initStage", dto);
	}

	@Override
	public StageDTO selectStage(StageDTO dto) {
		return sqlSession.selectOne("stageMapper.selectStage", dto);
	}

	@Override
	public int updateStage(StageDTO dto) {
		return sqlSession.update("stageMapper.updateStage", dto);
	}

	@Override
	public MemberDTO outlastTwoSelectMember(MemberDTO dto) {
		return sqlSession.selectOne("stageMapper.outlastTwoSelectMember", dto);
	}
	
	
}
