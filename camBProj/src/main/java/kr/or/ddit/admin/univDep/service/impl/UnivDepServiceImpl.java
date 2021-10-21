package kr.or.ddit.admin.univDep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.admin.univDep.mapper.UnivDepMapper;
import kr.or.ddit.admin.univDep.service.UnivDepService;
import kr.or.ddit.admin.univDep.vo.UnivDepVO;
import kr.or.ddit.admin.univDep.vo.UnivVO;

@Service
public class UnivDepServiceImpl implements UnivDepService{
	
	@Autowired
	UnivDepMapper univDepMapper;

//	학과 목록
	@Override
	public List<UnivDepVO> selectUnivDepList(UnivDepVO univDepVo) throws Exception {
		return univDepMapper.selectUnivDepList(univDepVo);
	}

//	전체 학과 수
	@Override
	public int totalUnivDep(UnivDepVO univDepVo) throws Exception {
		return univDepMapper.totalUnivDep(univDepVo);
	}

//	대학 목록
	@Override
	public List<UnivVO> selectUnivList() throws Exception {
		return univDepMapper.selectUnivList();
	}
	
//	학과 등록 전 학과 번호 생성
	@Override
	public String makeUnivDepNum() throws Exception {
		return univDepMapper.makeUnivDepNum();
	}
	
//	학과 등록
	@Override
	public String insertUnivDep(UnivDepVO univDepVo) throws Exception {
		
		int affectedRowCnt = univDepMapper.insertUnivDep(univDepVo);
		if(affectedRowCnt > 0) {	//insert 성공
			return univDepVo.getUnivDeptNum();	
		}else {	//insert 실패 시 0 리턴
			return null;
		}
	}

//	학과 디테일 보기
	@Override
	public UnivDepVO selectUnivDepDetail(String univDeptNum) throws Exception {
		return univDepMapper.selectUnivDepDetail(univDeptNum);
	}

//	학과 수정
	@Override
	public int updateUnivDep(UnivDepVO univDepVo) throws Exception {
		return univDepMapper.updateUnivDep(univDepVo);
	}

//	학과 삭제
	@Override
	public int deleteUnivDep(UnivDepVO univDepVo) throws Exception {
		return univDepMapper.deleteUnivDep(univDepVo);
	}

}
