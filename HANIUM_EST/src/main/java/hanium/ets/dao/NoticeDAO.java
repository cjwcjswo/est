package hanium.ets.dao;

import java.util.List;

import hanium.ets.dto.BoardDTO;

public interface NoticeDAO {
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
