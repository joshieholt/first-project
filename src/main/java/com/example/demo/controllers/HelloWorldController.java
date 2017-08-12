package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import com.example.demo.models.Adder;
import com.example.demo.models.Yeller;
import com.example.demo.models.Whisperer;

@Controller
@RequestMapping({ "/", "/HelloWorld" })
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	@PostMapping("say-something")
	public String speakToMe(Model model) {
		
		model.addAttribute("title",title);
		model.addAttribute("output","");
		return "helloworld/mixed-messages";
	}
	
	@GetMapping("say-something")
	public String makeAChoice(String message, String speechChoice, Model model) {
		String result = "";
		if (speechChoice.equals("yell")) {
				Yeller yeller = new Yeller(message);
				result = yeller.yell();
		}
		else if (speechChoice.equals("whisper")) {
			Whisperer whisperer = new Whisperer(message);
			result = whisperer.whisper();
		}
		model.addAttribute("title", title);
		model.addAttribute("output", result);
		return "helloworld/mixed-messages";
	}
	
}
