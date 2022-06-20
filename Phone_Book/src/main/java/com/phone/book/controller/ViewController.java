package com.phone.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phone.book.model.PhoneBook;
import com.phone.book.reposistory.PhonePbookRepos;
import com.phone.book.service.PhoneBookService;

@RestController
public class ViewController {

	@Autowired
	PhonePbookRepos phonePros;
	@Autowired
	PhoneBookService phoneBookService;
	
	@RequestMapping("/viewAllDate")
	public List<PhoneBook> viewDate()
	{
		return phonePros.findAll();
	}
	@GetMapping("/kundan")
	public String showme()
	{
		return "kundan kumar is here.....";
	}
	
	
}
