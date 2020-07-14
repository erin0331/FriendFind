package com.find.friend;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReplyDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public List<ReplyDTO> ListAll(String id) {
		
		List<ReplyDTO> list = my.selectList("reply.list", id);
		return list;
	}
	public int update(ReplyDTO dto) {
		int result = my.update("reply.update", dto);
		return result;
	}
	public int insert(ReplyDTO dto) {
		int result = my.insert("reply.insert", dto);
		return result;
	}
	public ReplyDTO selectOne(ReplyDTO dto) {
		ReplyDTO dto2= my.selectOne("reply.one", dto);
		return dto2;
	}
	public int getNextSeq(ReplyDTO dto) {
		int seq= my.selectOne("reply.getNextSeq", dto);
		return seq;
	}
	public int insertRe(ReplyDTO dto) {
		int result = my.insert("reply.insertRe", dto);
		return result;
	}
	public int updateSeq(ReplyDTO dto) {
		int result = my.update("reply.updateSeq", dto);
		return result;
	}
	
	public int delete(ReplyDTO dto) {
		int result = my.delete("reply.delete", dto);
		return result;
	}
	public List<ReplyDTO> getDeleteChild(ChildInfoDTO dto) {
		
		List<ReplyDTO> list = my.selectList("reply.getDeleteChild", dto);
		return list;
	}
	public ChildInfoDTO selectChildInfo(ReplyDTO dto) {
		ChildInfoDTO dto2= my.selectOne("reply.selectChildInfo", dto);
		return dto2;
	}
}
