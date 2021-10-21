package kr.or.ddit.student.tuitionPayment.service.impl;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.or.ddit.student.tuitionPayment.mapper.VrtAccntCodeMapper;
import kr.or.ddit.student.tuitionPayment.service.VrtAccntService;
import kr.or.ddit.student.tuitionPayment.vo.VrtAccntCodeVO;

@Service
public class VrtAccntServiceImpl implements VrtAccntService {
	
	@Autowired
	VrtAccntCodeMapper vrtAccntCodeMapper;
	
	/**
	 * 가상계좌 10000개 생성하기
	 */
	@Override
	public void vrtAccntCodeInsert() {
		int vrtAccntCodeCount = vrtAccntCodeMapper.vrtAccntCodeCount(new VrtAccntCodeVO());
		String bankCode = "01"; // 은행 코드는 하나로 하기

		// 총 1000개가 될때까지 생성
		while(vrtAccntCodeCount < 1000) {
			VrtAccntCodeVO vrtAccntCodeVo = new VrtAccntCodeVO();
			// 랜덤 생성 14자리 숫자
			String vrtAccnt = getVrtAccnt();
			System.out.println(vrtAccnt);
			vrtAccntCodeVo.setVrtAccnt(vrtAccnt);
			vrtAccntCodeVo.setBankCode(bankCode);
			vrtAccntCodeMapper.vrtAccntCodeInsert(vrtAccntCodeVo);
			vrtAccntCodeCount = vrtAccntCodeMapper.vrtAccntCodeCount(vrtAccntCodeVo);
		}
	}
	
	/**
	 * 14자리 가상 계좌 번호 생성
	 * @return vrtAccnt : 14 자리 랜덤한 숫자
	 */
	private String getVrtAccnt() {
		Random random = new Random();
		String vrtAccnt = "";
		for(int i = 0; i < 14; i++) {
			 vrtAccnt += Integer.toString(random.nextInt(10)); 
		}
		return vrtAccnt;
	}
	
	/**
	 * 사용할 수 있는 계좌번호 가져오고 업데이트하기
	 * 1. USE_YN가 N인 계좌 번호 하나 가져오기
	 * 2. 해당 계좌 번호 사용 USE_YN 를 Y로 업데이트, 파라미터로 받은 mem_id로 업데이트
	 * 3. 해당 VrtAccntCodeVO return
	 */
	@Override
	public VrtAccntCodeVO vrtAccntCodeSelectAndUpdate(String memId) {
		VrtAccntCodeVO vrtAccntCodeVo = new VrtAccntCodeVO();
		vrtAccntCodeVo.setUseYn("N");
		List<VrtAccntCodeVO> list = vrtAccntCodeMapper.vrtAccntCodeSelect(vrtAccntCodeVo);
		vrtAccntCodeVo = list.get(0); 
		
		vrtAccntCodeVo.setMemId(memId);
		vrtAccntCodeVo.setUseYn("Y");
		vrtAccntCodeMapper.vrtAccntCodeUpdate(vrtAccntCodeVo);
		return vrtAccntCodeVo;
	}
	
	/**
	 * 사용이 끝난 계좌 번호 업데이트하기 
	 * 해당 계좌 번호를 파라미터로 받아서 사용 USE_YN 를 N로 업데이트, mem_id NULL로 업데이트
	 */
	@Override
	public void vrtAccntCodeUpdate(String vrtAccnt) {
		VrtAccntCodeVO vrtAccntCodeVo = new VrtAccntCodeVO();
		vrtAccntCodeVo.setVrtAccnt(vrtAccnt);
		vrtAccntCodeMapper.vrtAccntCodeSelect(vrtAccntCodeVo);
		
		vrtAccntCodeVo.setUseYn("N"); // mem_id는 set하지 않아서 null로 들어감
		vrtAccntCodeMapper.vrtAccntCodeUpdate(vrtAccntCodeVo);
	}
}
