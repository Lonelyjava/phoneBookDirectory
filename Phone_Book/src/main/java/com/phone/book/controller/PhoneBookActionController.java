package com.phone.book.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phone.book.model.PhoneBook;
import com.phone.book.service.PhoneBookService;



@Controller
@RequestMapping("/nameSearch")
public class PhoneBookActionController {
	
	@Autowired 
	PhoneBookService phoneBookService;
	
	private static final String VIEW = "view";
	private static final String VIEWPHONEBOOK = "viewPhoneBook";

	
	@RequestMapping("/edit")
	public String editPhoneBook(Model model, PhoneBook phoneBook, HttpServletRequest request) {
		String id = request.getParameter("id");
		System.out.println("edit-------------" + id);
		return VIEW;
	}

	@RequestMapping("/view")
	public String view(Model model, PhoneBook phoneBook, HttpServletRequest request) {
		String id = request.getParameter("id");
		long ids=Long.parseLong(id); 
		List<PhoneBook> list = phoneBookService.getViewPhoneBook(ids);
		for(PhoneBook e:list)
		{
			System.out.println("----------------------");
			
			System.out.println(e.getPhonebook_id() +"----"+e.getFname());
			System.out.println("----------------------");
			Date date=e.getRegister_date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
            String strDate = dateFormat.format(date); 
            System.out.println(strDate.substring(1, 10));
		}
		System.out.println("view-------------" + id);
		model.addAttribute("phoneBookList",list);
		return VIEWPHONEBOOK;
	}

}
