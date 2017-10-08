package hanium.ets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hanium.ets.dao.NoticeDAO;
@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	NoticeDAO noticeDAO;
	
	@Override
	public int insertNotice(String content) {
		return noticeDAO.insertNotice(content);
	}

	@Override
	public List<String> loadNotice() {
		return noticeDAO.loadNotice();
	}

}
