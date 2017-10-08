package hanium.ets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hanium.ets.dao.StageDAO;
import hanium.ets.dto.MemberDTO;
import hanium.ets.dto.StageDTO;

@Service
public class StageServiceImpl implements StageService{

	@Autowired
	StageDAO stageDAO;
	
	@Override
	public int initStage(StageDTO dto) {
		return stageDAO.initStage(dto);
	}

	@Override
	public StageDTO selectStage(StageDTO dto) {
		return stageDAO.selectStage(dto);
	}

	@Override
	public int updateStage(StageDTO dto) {
		return stageDAO.updateStage(dto);
	}

	@Override
	public MemberDTO outlastTwoSelectMember(MemberDTO dto) {
		return stageDAO.outlastTwoSelectMember(dto);
	}

}
