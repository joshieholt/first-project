package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
import com.example.demo.models.Yeller;
import com.example.demo.models.Whisperer;

@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	@GetMapping("message")
	public ModelAndView message(@RequestParam(required=false, defaultValue="«silence»") String message) {
		Yeller yeller = new Yeller(message);
		String result = yeller.yell();
		
		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("title", title);
		mv.addObject("message", result);
		return mv;
	}
	
	@GetMapping("whisper")
	public ModelAndView whisper(@RequestParam(required=false, defaultValue="«shhhhh»") String message) {
		Whisperer whisperer = new Whisperer(message);
		String result = whisperer.whisper();
		
		ModelAndView mv = new ModelAndView("helloworld/whisper");
		mv.addObject("title", title);
		mv.addObject("message", result);
		return mv;
	}
	
//	@GetMapping("message-path") this is the url path that will cause java to call this method
//	public ModelAndView messageMethod(@RequestParam(required=false, defaultValue="«silence»") String submittedMessage) {
//		Yeller yeller = new Yeller(submittedMessage);
//		String result = yeller.yell();
//		
//		ModelAndView mv = new ModelAndView("helloworld/message"); this tells it which template to get/use
//		mv.addObject("title", title);
//		mv.addObject("message", result);  this 'message' is the placeholder moustache used in the html template.  it will be replaced by 'result' variable value
//		return mv;
//	}

	@PostMapping("adder")
	public String addTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, Model model) {
		Adder adder = new Adder(first, second);
		double result = adder.calculate();
		
		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}
	
}
