package com.phone.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phone.book.model.PhoneBook;
import com.phone.book.reposistory.MobileNumCheckRepository;

@Service
public class MobileNumCheckService {

	
	@Autowired
	
	MobileNumCheckRepository  mobileNumCheckRepository;
	
	public List<PhoneBook>  checkMobileExists(String mobile)
	{
		return mobileNumCheckRepository.findAll();
	}
}
