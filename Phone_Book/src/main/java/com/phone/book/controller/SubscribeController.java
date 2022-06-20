package com.phone.book.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phone.book.model.PhoneBook;
import com.phone.book.model.Subscribe;
import com.phone.book.reposistory.PhonePbookRepos;
import com.phone.book.service.SubscribeService;

@Controller
public class SubscribeController {

	@Autowired
	SubscribeService subscribeService;
	
	@Autowired
	PhonePbookRepos phonePbookRepos;

	@RequestMapping(value = "/showSubs")
	public String showSubs(Model model) {
		
		List<PhoneBook> phonebook=phonePbookRepos.findAll();
		model.addAttribute("phonebook",phonebook);
		return "subscribe";
	}

	@RequestMapping(value = "/saveData")
	public String saveData(Subscribe Subscribe, Model model) {
		Date date = new Date();
		Subscribe.setCreatedDate(date);

		subscribeService.saveInfo(Subscribe);
		String msg = "Date Saved Successfully";
		model.addAttribute("message", msg);
		System.out.println("saved.........");
		return "subscribe";
	}
}
