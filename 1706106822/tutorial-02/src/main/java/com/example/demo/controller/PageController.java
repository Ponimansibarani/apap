package com.example.demo.controller;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
	@RequestMapping("/hello2")
	public String hello2(@RequestParam(value="name") String name,Model model) {
		model.addAttribute("name", name);
		return "hello2";
	}
	@RequestMapping(value= {"/hello2", "/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name,Model model) {
		if(name.isPresent()) {
			model.addAttribute("name",name.get());
		}
		else {
			model.addAttribute("name","Phoenix");
		}
		return "hello2";
	}
	
	//LATIHAN CALCU-CONVERT
	@RequestMapping("/numberCalculator")
	public String calculate(@RequestParam(value="number1") String number1 , @RequestParam(value="number2")String number2,Model model){
		String[] angka= {"satu","dua","tiga","empat","lima"
						,"enam","tujuh","delapan","sembilan","sepuluh"};
		int num1=Integer.parseInt(number1);
		int num2=Integer.parseInt(number2);
		int jum=num1+num2;
		
		String hasil=number1+" + "+number2+" = "+jum+" ("+angka[jum-1]+")";
		model.addAttribute("hasil", hasil);
		return "numberCalculator";
	}
	
}
