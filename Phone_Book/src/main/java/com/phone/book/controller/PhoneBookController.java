package com.phone.book.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phone.book.model.PhoneBook;
import com.phone.book.model.SearchHistory;
import com.phone.book.service.MobileNumCheckService;
import com.phone.book.service.PhoneBookService;
import com.phone.book.service.SearchHistoryService;

@Controller
public class PhoneBookController {

	private static final String INDEX = "index";
	private static final String VIEW = "view";
//kundan
	@Autowired 
	PhoneBookService phoneBookService;
	
	@Autowired
	MobileNumCheckService mobileNumCheckService;
	
	@Autowired
	SearchHistoryService searchHistoryService;

	@RequestMapping("/openBook")
	public String openPhoneBook() {

		return INDEX;
	}
	@ModelAttribute("countryList")
	   public Map<String, String> getCountryList() {
	      Map<String, String> countryList = new HashMap<String, String>();
	      countryList.put("US", "United States");
	      countryList.put("CH", "China");
	      countryList.put("SG", "Singapore");
	      countryList.put("MY", "Malaysia");
	      return countryList;
	   }

	@RequestMapping("/saves")
	public String savePhoneBook(HttpServletRequest request, PhoneBook phoneBook, Model model) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		System.out.println(strDate);
		phoneBook.setRegister_date(date);
		phoneBook.setFromDate(date);
		phoneBook.setToDate(date);
		String fname1 = request.getParameter("fname");
		if (fname1 != null) {
			phoneBookService.saveRecord(phoneBook);
		} else {
			String fname = "First name can not be blank";
			model.addAttribute("messagefname", fname);
		}

		String msg = "Date Saved Successfully";
		model.addAttribute("message", msg);
		System.out.println("Data saved Successfully....." + phoneBook.getFname());
		return INDEX;

	}

	@RequestMapping("/loginPage")
	public String login() {
		System.out.println("login pages executed .............");
		return "login";
	}

	@RequestMapping("/registerUser")
	public String signUp() {
		return "signUp";
	}

//	@RequestMapping("/singUpsave")
//	public String saveSignUp(SignUp signUp, Model model) {
//		singUpRepos.save(signUp);
//		System.out.println("Sign Up successfully....." + signUp.getFirstName());
//		String msg = "Sign Up successfully";
//		model.addAttribute("message", msg);
//		return "signUp";
//	}

	@RequestMapping("/forgatePassword")
	public String forgatePassword() {
		return "forgate password is under processing !";
	}

	@RequestMapping("/nameSearch")
	public String viewRecords(ModelMap model, HttpServletRequest request,SearchHistory searchHistory) throws Exception {
		String name = request.getParameter("fname");
		System.out.println(name);
		saveSearchHistory(searchHistory);
		List<PhoneBook> phoneBookRecords = phoneBookService.findBynameSearch(name);
		if (phoneBookRecords.size() > 0) {
			model.put("phoneBook", phoneBookService.findBynameSearch(name));
		} else {
			String messgae = "No Record Found";
			model.put("msg", messgae);
		}

		return VIEW;
	}

	public void saveSearchHistory(SearchHistory searchHistory)
	{
		Date date = new Date();
		searchHistory.setCreatedDate(date);
		searchHistoryService.saveSearchHistory(searchHistory);
	}
	
	@RequestMapping("/allRecordsfromPhonebook")
	public String search(ModelMap model, HttpServletRequest request) {
		try {
			List<PhoneBook> phoneBookRecords = phoneBookService.getRecords();

			model.put("phoneBook", phoneBookRecords);
		} catch (Exception e) {
			e.getMessage();
		}
		return VIEW;
	}

	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam CommonsMultipartFile file, HttpSession session) {
		String path = session.getServletContext().getRealPath("/");
		String filename = file.getOriginalFilename();

		System.out.println(path + " " + filename);
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("upload-success", "filename", path + "/" + filename);
	}
	
	
	
	  @RequestMapping(value="/checkmobile1/{mobile}")
	  public 
	  List<PhoneBook> checkmobileNo(@PathVariable("mobile") String mobile,Model
	  model) { System.out.println("listCount;;;;;;;;"+mobile); List<PhoneBook>
	  listCount=mobileNumCheckService.checkMobileExists(mobile);
	  
	  return listCount; }
	 
}
