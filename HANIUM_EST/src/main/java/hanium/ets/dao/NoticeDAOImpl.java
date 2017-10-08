package hanium.ets.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAOImpl implements NoticeDAO{

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertNotice(String content) {
		return sqlSession.insert("noticeMapper.insertNotice", content);
	}

	@Override
	public List<String> loadNotice() {
		return sqlSession.selectList("noticeMapper.loadNotice");
	}
	
	
}
