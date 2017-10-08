package hanium.ets.service;

import java.util.List;

public interface NoticeService {
	/**
	 * 알림 삽입
	 * @param content 알림 내용
	 * @return
	 */
	int insertNotice(String content);
	
	/**
	 * 알림 불러오기
	 * @return 알림리스트
	 */
	List<String> loadNotice();
}
