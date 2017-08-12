package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Calculator;

@Controller
@RequestMapping("/calculator")
public class MathsController {
//	private String title;
//	
//	public MathsController() {
//		title = "Do The Maths!";
//	}
	
	@PostMapping("")
	public String adder() {
		return "calculator/mathser";
	}
	
	@PostMapping("mathser")
	public String addTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, @RequestParam(name="calcChoice") String operation, Model model) {
		Calculator adder = new Calculator(first, second, operation);
		double result = adder.calculate();
		
		model.addAttribute("sum", result);
		return "calculator/maths-result";
	}
}
