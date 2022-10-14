package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("name","홍길동");
		return "/test";
	}
}
