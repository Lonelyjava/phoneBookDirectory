package com.phone.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PhonebookRegisController {

	@RequestMapping(value="/phonebookRegis")
	public String showPage()
	{
		return "phonebookRegis";
	}
}
