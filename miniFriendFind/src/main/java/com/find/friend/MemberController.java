package com.find.friend;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	@Autowired
	SubMemberDAO dao2;
	
	@RequestMapping("insert.do")
	public void insert(MemberDTO memberDTO) {
		System.out.println(memberDTO);
		dao.insert(memberDTO);
		
	}
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		session.removeAttribute("nickName");
		return "redirect: start.jsp";
	}
	@RequestMapping("home.do")
	public String goHome() {
		return "main";
	}
	
	@RequestMapping("selectall.do")
	public void selectall(Model model) {
		List<MemberDTO> list = dao.selectall();
		model.addAttribute("memberlist", list);
		
	}
	@RequestMapping("selectid.do")
	public void selectid(MemberDTO memberDTO, Model model) {
		int result = dao.selectid(memberDTO);
		if (result == 0) {
			model.addAttribute("idcheck", "사용가능합니다.");	
		}else {
			model.addAttribute("idcheck", "사용불가능합니다.");	
		}	
	}
	@RequestMapping("selectpw.do")
	public String selectpw(MemberDTO memberDTO, Model model, HttpSession session) {
		System.out.println("ct"+memberDTO);
		int result = dao.selectpw(memberDTO);
		MemberDTO dto2 = dao.selectpw2(memberDTO);
		model.addAttribute("pwcheck", dto2);
		String where;
		if (result == 0) {
			
			return "redirect: start.jsp";
		}else {	
			List<Addr1DTO> list1 = dao2.firstsub1();
			List<HobbyDTO> list2 = dao2.firstsub2();
			List<JobDTO> list3 = dao2.firstsub3();		
			model.addAttribute("list1", list1);
			model.addAttribute("list2", list2);
			model.addAttribute("list3", list3);
			session.setAttribute("id", dto2.getId());
			session.setAttribute("nickName", dto2.getNickName());
			where = "main";
		}
		
		return where;
	}
	@RequestMapping("update.do")
	public void update(MemberDTO memberDTO) {
		dao.update(memberDTO);
	}
	@RequestMapping("searchhobby.do")
	public void searchselect(MemberDTO memberDTO ,Model model) {
		System.out.println("c");
		List<MemberDTO> list = dao.searchhobby(memberDTO);
		System.out.println("list사이즈"+ list.size());
		System.out.println("--반복문--");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			MemberDTO dto2 = list.get(i); //첫번째 List에 있는 dto화
			System.out.println("-------------------------");
			System.out.println("--반복문시작--");
			System.out.println(i + "===" + dto2 + "1");
			
			List<MemberDTO> list2 = dao.hangle(dto2); //dto 숫자를 한글화
			System.out.println(list2.size() + "----------------");
			MemberDTO dto3 = list2.get(0);
			System.out.println(dto3 + "2");
			System.out.println("--마무리---");
			String[] hobby = dto2.getHobby().split(", ");
			System.out.println("hobby길이 : " +hobby.length);
			String hhobby = "";
			for (int j = 0; j < hobby.length; j++) {
				HobbyDTO dto5 = new HobbyDTO();
				dto5.setHobbyNum(hobby[j]);
				System.out.println("dto5:"+dto5);
				HobbyDTO tempDto = dao2.hanglehob(dto5);
				System.out.println("--------"+tempDto);
				//dto5 = hlist.get(0);
				hhobby = hhobby+ ", " + tempDto.getHobby();
			}
			
			dto2.setAddr1(dto3.getAddr1());
			dto2.setAddr2(dto3.getAddr2());
			dto2.setHobby(hhobby);
			dto2.setJob(dto3.getJob());
			dto2.setSubJob(dto3.getSubJob());
			list.set(i , dto2); //여기서 변동을 주면 위에서 추가 된 것으로 여겨져서 list.size()값이 바뀐다.
		}
		model.addAttribute("searchlist", list);
	}
	@RequestMapping("searchjob.do")
	public void searchjob(MemberDTO memberDTO ,Model model) {
		System.out.println("c" + memberDTO);
		List<MemberDTO> list = dao.searchjob(memberDTO);
		System.out.println("list사이즈"+ list.size());
		int size = list.size();
		for (int i = 0; i < size; i++) {
			MemberDTO dto2 = list.get(i); //첫번째 List에 있는 dto화
			System.out.println("-------------------------");
			System.out.println("--반복문시작--");
			System.out.println(i + "===" + dto2 + "1");
			
			List<MemberDTO> list2 = dao.hangle(dto2); //dto 숫자를 한글화
			System.out.println(list2.size() + "----------------");
			MemberDTO dto3 = list2.get(0);
			System.out.println(dto3 + "2");
			System.out.println("--마무리---");
			String[] hobby = dto2.getHobby().split(", ");
			System.out.println(hobby.length);
			String hhobby = "";
			for (int j = 0; j < hobby.length; j++) {
				HobbyDTO dto5 = new HobbyDTO();
				dto5.setHobbyNum(hobby[j]);
				HobbyDTO tempDto = dao2.hanglehob(dto5);
				System.out.println("--------"+tempDto);
				hhobby = hhobby+ ", " + tempDto.getHobby();
//				List<HobbyDTO> hlist = dao2.hanglehob(dto5);
//				dto5 = hlist.get(0);
//				hhobby = hhobby+ ", " + dto5.getHobby();
			}
			
			dto2.setAddr1(dto3.getAddr1());
			dto2.setAddr2(dto3.getAddr2());
			dto2.setHobby(hhobby);
			dto2.setJob(dto3.getJob());
			dto2.setSubJob(dto3.getSubJob());
			list.set(i , dto2); 
		}
		model.addAttribute("searchlist", list);
	}
}
