package hanium.ets.service;

import java.util.List;

public interface NoticeService {
	/**
	 * �˸� ����
	 * @param content �˸� ����
	 * @return
	 */
	int insertNotice(String content);
	
	/**
	 * �˸� �ҷ�����
	 * @return �˸�����Ʈ
	 */
	List<String> loadNotice();
}
