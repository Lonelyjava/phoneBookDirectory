package com.phone.book.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentController {
	
	
	@RequestMapping("/hello")
	public String show()
	{
		
		
		return "success";
	}

}
