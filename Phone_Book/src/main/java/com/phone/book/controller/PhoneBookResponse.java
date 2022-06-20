package com.phone.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phone.book.model.PhoneBook;
import com.phone.book.service.MobileNumCheckService;

@RestController
@RequestMapping("/registerUser")
public class PhoneBookResponse {

	
	@Autowired
	MobileNumCheckService mobileNumCheckService;
	
	@RequestMapping(value="/abc/mobile",method=RequestMethod.GET)
	@ResponseBody
	public List<PhoneBook> checkmobileNo(@RequestBody String mobile,Model model)
	{
		System.out.println("listCount;;;;;;;;"+mobile);
		List<PhoneBook> listCount=mobileNumCheckService.checkMobileExists(mobile);
		
		return listCount;
	}
	
}
