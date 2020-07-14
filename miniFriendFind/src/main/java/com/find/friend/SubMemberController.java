package com.find.friend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SubMemberController {

	@Autowired
	SubMemberDAO dao;
	
	@RequestMapping("firstsub.do")
	public String firstsub(Model model) {
		List<Addr1DTO> list1 = dao.firstsub1();
		List<HobbyDTO> list2 = dao.firstsub2();
		List<JobDTO> list3 = dao.firstsub3();		
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		model.addAttribute("list3", list3);
		return "member";
	}
	@RequestMapping("secondsub.do")
	public void secondsub(Addr2DTO addr2DTO,Model model) {
		System.out.println("c"+addr2DTO);
		List<Addr2DTO> list4 = dao.secondsub(addr2DTO);
		System.out.println(list4);
		model.addAttribute("list4", list4);
	}
	@RequestMapping("thridsub.do")
	public void thridsub(subJobDTO subjobDTO, Model model) {
		List<subJobDTO> list5 = dao.thirdsub(subjobDTO);
		model.addAttribute("list5", list5);
	}
	@RequestMapping("searchui.do")
	public void seacherui(Model model) {
		List<Addr1DTO> list1 = dao.firstsub1();
		List<HobbyDTO> list2 = dao.firstsub2();
		List<JobDTO> list3 = dao.firstsub3();		
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		model.addAttribute("list3", list3);
	}
}
