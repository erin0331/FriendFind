package com.find.friend;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public MemberDTO select(String id) {
		
		MemberDTO dto = my.selectOne("member.one", id);
		return dto;
	}
	
	public void insert(MemberDTO dto) {
		System.out.println("m"+dto);
		my.insert("member.insert", dto);
	}
	
	public List<MemberDTO> selectall() {
		List<MemberDTO> list = my.selectList("member.selectall");
		return list;
	}
	
	public int selectid(MemberDTO dto) {
		MemberDTO dto2 = my.selectOne("member.selectid", dto);
		int result;
		if(dto2 != null) {
			result = 1;
		}else {
			result = 0;
		}
		return result;
	}
	
	public int selectpw(MemberDTO dto) {
		System.out.println("dao"+dto);
		MemberDTO dto2 = my.selectOne("member.selectpw", dto);
		System.out.println(dto2);
		int result;
		if (dto2 != null) {
			result = 1;
		}else {
			result = 0;
		}
		return result;
	}
	
	public MemberDTO selectpw2(MemberDTO dto) {
		MemberDTO dto2 = my.selectOne("member.selectpw", dto);
		return dto2;
	}
	
	public void update(MemberDTO dto) {
		my.update("member.update", dto);
	}
	
	public List<MemberDTO> searchhobby(MemberDTO dto) {
		System.out.println("d"+dto);
		List<MemberDTO> list = my.selectList("member.selecthobby", dto );
		return list;
	}
	
	public List<MemberDTO> searchjob(MemberDTO dto) {
		System.out.println("d"+dto);
		List<MemberDTO> list = my.selectList("member.selectjob", dto );
		return list;
	}
	
	public List<MemberDTO> hangle(MemberDTO dto) {
		List<MemberDTO> list = my.selectList("member.hangle", dto);
		return list;
	}
}
