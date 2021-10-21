package kr.or.ddit.util.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.util.code.mapper.CodeMapper;
import kr.or.ddit.util.code.service.CodeService;
import kr.or.ddit.util.code.vo.CodeVO;

@Service
public class CodeServiceImpl implements CodeService{
	
	@Autowired
	CodeMapper codeMapper;
	
	@Override
	public List<CodeVO> codeList(String codeType) {
		return codeMapper.codeList(codeType);
	}

	@Override
	public List<CodeVO> univDeqtCodeList() {
		return codeMapper.univDeqtCodeList();
	}

	@Override
	public List<CodeVO> univCodeList() {
		return codeMapper.univCodeList();
	}
	
}
