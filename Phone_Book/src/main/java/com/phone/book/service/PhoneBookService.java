package com.phone.book.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phone.book.model.PhoneBook;
import com.phone.book.model.SearchHistory;
import com.phone.book.reposistory.PhonePbookRepos;

@Service
public class PhoneBookService {

	@Autowired
	PhonePbookRepos phonePbookRepos;
	
	public PhoneBook saveRecord(PhoneBook phoneBook)
	{
		return phonePbookRepos.save(phoneBook);
	}
	
	public List<PhoneBook> getRecords()
	{
		return phonePbookRepos.findAll();
	}
	public List<PhoneBook> getAllRecords(Date fromDate,Date toDate)
	{
		List<?> list=phonePbookRepos.getRecords(fromDate,toDate);
		System.out.println("size"+list);
		return new ArrayList();
	}
	
	public List<PhoneBook> findBynameSearch(String fname)
	{
		List<PhoneBook> phone=phonePbookRepos.findByfname(fname);
		return phone;
	}

	public List<PhoneBook> getViewPhoneBook(long ids) {
		// TODO Auto-generated method stub
		return phonePbookRepos.getDetailsById(ids);
	}
	

}
