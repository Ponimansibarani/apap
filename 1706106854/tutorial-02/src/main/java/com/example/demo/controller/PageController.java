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
	public String hello2(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello2";
	}
	@RequestMapping(value= {"/hello2", "/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	@RequestMapping("/numberCalculator")
	public String numberCalculate(@RequestParam(value = "num1") String num1 , @RequestParam(value = "num2")String num2, Model model){
		String[] angka = {"satu","dua","tiga","empat","lima"
						,"enam","tujuh","delapan","sembilan","sepuluh"};
		int no1 = Integer.parseInt(num1);
		int no2 = Integer.parseInt(num2);
		int jumlah = no1 + no2;
		
		String hasil = num1 +" + "+ num2 +" = "+ jumlah +" ("+angka[jumlah - 1]+")";
		model.addAttribute("hasil", hasil);
		return "numberCalculator";
	}
}
