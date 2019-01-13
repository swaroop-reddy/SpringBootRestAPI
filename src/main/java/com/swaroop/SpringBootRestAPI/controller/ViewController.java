package com.swaroop.SpringBootRestAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ViewController {
	 @RequestMapping("/home")
	 public ModelAndView  home() {
		 return new ModelAndView("index");
	 }
}
