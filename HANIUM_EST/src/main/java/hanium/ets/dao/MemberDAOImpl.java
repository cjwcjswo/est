package hanium.ets.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hanium.ets.dto.AuthorityDTO;
import hanium.ets.dto.MemberDTO;
import hanium.ets.dto.PointDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insertMember(MemberDTO dto) {
		return sqlSession.insert("memberMapper.insertMember",dto);
	}

	@Override
	public MemberDTO checkId(MemberDTO dto) {
		return sqlSession.selectOne("memberMapper.checkId", dto);
	}

	@Override
	public int insertAuth(AuthorityDTO dto) {
		return sqlSession.insert("memberMapper.insertAuth", dto);
	}

	@Override
	public List<AuthorityDTO> selectAuth(String email) {
		return sqlSession.selectList("memberMapper.selectAuth", email);
	}

	@Override
	public int initPoint(PointDTO dto) {
		return sqlSession.insert("memberMapper.initPoint", dto);
	}

	@Override
	public int updatePoint(PointDTO dto) {
		return sqlSession.insert("memberMapper.updatePoint", dto);
	}

	@Override
	public PointDTO selectPoint(String email) {
		return sqlSession.selectOne("memberMapper.selectPoint", email);
	}

	@Override
	public List<PointDTO> selectRank() {
		return sqlSession.selectList("memberMapper.selectRank");
	}

}
