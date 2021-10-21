package kr.or.ddit.student.volunteer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.student.volunteer.mapper.VolunteerMapper;
import kr.or.ddit.student.volunteer.service.VolunteerService;
import kr.or.ddit.student.volunteer.vo.VolunteerVO;

@Service
public class VolunteerServiceImpl implements VolunteerService{
	@Autowired
	private VolunteerMapper volunteerMapper;
	
	@Override
	public List<VolunteerVO> volunteerAllList(Map<String, Object> map){
		return this.volunteerMapper.volunteerAllList(map);
	}
	
	@Override
	public VolunteerVO volRecogTimeAndGraduation(String stdId) {
		return this.volunteerMapper.volRecogTimeAndGraduation(stdId);
	}
	@Override
	public int insertVolunteer(VolunteerVO volunteerVo) {
		return this.volunteerMapper.insertVolunteer(volunteerVo);
	}
	
	@Override
	public VolunteerVO volunteerDetailList(String volNum) {
		return this.volunteerMapper.volunteerDetailList(volNum);
	}
	
	@Override
	public int deleteVolunteer(String volNum) {
		return this.volunteerMapper.deleteVolunteer(volNum);
	}
	
	@Override
	public int updateVolunteer(VolunteerVO volunteerVo) {
		return this.volunteerMapper.updateVolunteer(volunteerVo);
	}
	
	@Override
	public int selectCount(Map<String, Object> map) {
		return this.volunteerMapper.selectCount(map);
	}
	
	
}
