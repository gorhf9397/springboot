package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	@Autowired
	private BoardMapper mapper;
	
	@RequestMapping("/")
	public String home()
	{
		return "redirect:/list";
	}
	
	@RequestMapping("/write")
	public String write()
	{
		return "/write";
	}
	
	@RequestMapping("/write_ok")
	public String write_ok(BoardVO bvo)
	{
		mapper.write_ok(bvo);
		return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("list",mapper.list());
		return "/list";
	}
	@RequestMapping("/content")
	public String content(HttpServletRequest request,Model model) {
		String id = request.getParameter("id");
		BoardVO bdto = mapper.content(id);
		model.addAttribute("bdto",bdto);
		return "/content";
	}
	@RequestMapping("/delete")
	public String delete(BoardVO bvo) {
		int id = bvo.getId();
		String pwd = bvo.getPwd();
		if(mapper.getpwd(id, pwd) == 1) {
			mapper.delete(bvo.getId());
			return "redirect:/list";
		} else {
			return "redirect:/content?id="+bvo.getId();
		}
	}
	@RequestMapping("/update")
	public String update(HttpServletRequest request,Model model) {
		String id = request.getParameter("id");
		BoardVO bdto = mapper.update(id);
		model.addAttribute("bdto",bdto);
		return "/update";
	}
	@RequestMapping("/update_ok")
	public String update_ok(BoardVO bvo) {
		mapper.update_ok(bvo);
		if(mapper.getpwd(bvo.getId(), bvo.getPwd()) == 1) {
			mapper.update_ok(bvo);
			return "redirect:/content?id="+bvo.getId();
		} else {
			return "redirect:/update?id="+bvo.getId();
		}
	}
}
