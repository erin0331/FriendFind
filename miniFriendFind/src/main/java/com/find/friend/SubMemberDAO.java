package com.find.friend;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubMemberDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public List<Addr1DTO> firstsub1() {
		List<Addr1DTO> list1 = my.selectList("submember.addr1");
		return list1;
	}
	
	public List<HobbyDTO> firstsub2() {
		List<HobbyDTO> list2 = my.selectList("submember.hobby");
		return list2;
	}
	
	public List<JobDTO> firstsub3() {
		List<JobDTO> list3 = my.selectList("submember.job");
		return list3;
	}
	
	public List<Addr2DTO> secondsub(Addr2DTO dto) {
		System.out.println("m"+dto);
		List<Addr2DTO> list4 = my.selectList("submember.addr2", dto);
		return list4;
	}
	
	public List<subJobDTO> thirdsub(subJobDTO dto) {
		List<subJobDTO> list5 = my.selectList("submember.subjob", dto);
		return list5;
	}
	
	public HobbyDTO hanglehob(HobbyDTO dto) {
		HobbyDTO dto2 = my.selectOne("submember.hanglehobby", dto);
		return dto2;
	}
}
