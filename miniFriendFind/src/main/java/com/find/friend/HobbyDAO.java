package com.find.friend;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HobbyDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public List<HobbyDTO> getPickHobby(String[] hobbys) {
		List<HobbyDTO> list = my.selectList("hobby.getPickHobby", hobbys);
		return list;
	}
}
