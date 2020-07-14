package com.find.friend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReplyController {

	@Autowired
	ReplyDAO rDao;

	@Autowired
	MemberDAO mDao;

	@Autowired
	HobbyDAO hDao;

	@RequestMapping("detailPage.do")
	public void goDetail(String id, Model model) {
		List<ReplyDTO> list = rDao.ListAll(id);
		/*
		 * for (ReplyDTO replyDTO : list) { System.out.println(replyDTO); }
		 */
		model.addAttribute("list", list);
		// 페이지 주인 정보 불러오기
		MemberDTO dto = mDao.select(id);
		model.addAttribute("dto", dto);

		// 취미들 라벨 하나하나 가져오기
		String allHobby = dto.getHobby();
		String[] oneHobby = allHobby.split(", ");
		List<HobbyDTO> hobbyList = hDao.getPickHobby(oneHobby);
		model.addAttribute("hobbyList", hobbyList);

	}

	@RequestMapping("replyUpdate.do")
	public void update(ReplyDTO replyDTO) {
		int result = rDao.update(replyDTO);
		if (result == 0) {
			System.out.println("댓글 update잘 안됨");
		} else {
			System.out.println("댓글 update완료");
		}
	}

	@RequestMapping("replyInsert.do")
	public void insert(ReplyDTO replyDTO) {
		replyDTO.setUpId(0);
		replyDTO.setSeq(1);
		replyDTO.setDepth(1);

		int result = rDao.insert(replyDTO);
		if (result == 0) {
			System.out.println("댓글 작성 잘 안됨");
		} else {
			System.out.println("댓글 작성완료");
		}
	}

	@RequestMapping("replyDelete.do")
	public void delete(ReplyDTO replyDTO) {
		// 미리 댓글 자식정보 가져온 후
		ChildInfoDTO cDTO = rDao.selectChildInfo(replyDTO);
		System.out.println("지울애 : " + replyDTO.getId());
		// 댓글 지우고
		int result = rDao.delete(replyDTO);
		if (result == 0) {
			System.out.println("댓글 삭제 잘 안됨");
		} else {
			System.out.println("댓글 삭제완료");
			if (cDTO == null) {
				System.out.println("null이라 머없듬");
			} else {
				cDTO.setOwner(replyDTO.getOwner());
				List<ReplyDTO> list = rDao.getDeleteChild(cDTO);
				int pathIndex = cDTO.getDepth(); // 대댓글의 path를 배열로 쪼개 이 인덱스 값이 지울id와 같으면 그 차일드란뜻
				int id = replyDTO.getId();
				if (list == null) {
					System.out.println("대댓글 삭제 없거나 안됨");
				} else {
					for (ReplyDTO dto : list) {
						System.out.println(dto);
						String[] path = dto.getPath().split("/");
						if (Integer.parseInt(path[pathIndex]) == id) {
							result = rDao.delete(dto);
							if (result != 0) {
								System.out.println(dto.getId() + " 대댓글 삭제완료");
							}
						}
					}
				}
			}

		}
	}

	@RequestMapping("replyRe.do")
	public void insertRe(ReplyDTO replyDTO, Model model) {
		// 대댓글의 부모댓글의 정보를 가져옴
		ReplyDTO dto = rDao.selectOne(replyDTO);
		// 새 댓글은 깊이가 +1됨
		int depth = dto.getDepth() + 1;
		// 새 seq는 형제댓글중의 max(seq)+1
		int seq = rDao.getNextSeq(replyDTO);
		// 새 seq와 비교하여 그 이상의 seq를가진 기존 댓글을 seq+1로 미룸
		replyDTO.setSeq(seq);
		System.out.println("depth:" + depth + "...seq : " + seq);

		int result = rDao.updateSeq(replyDTO);
		System.out.println(result + "건 seq update완료");
		// 대댓글용 세팅
		System.out.println("부모댓글:" + replyDTO.getId());
		replyDTO.setUpId(replyDTO.getId());
		replyDTO.setSeq(seq);
		replyDTO.setDepth(depth);
		System.out.println(replyDTO);
		// 대댓글 insert
		result = rDao.insert(replyDTO);
		System.out.println("대댓글 작성됨");
	}

}
