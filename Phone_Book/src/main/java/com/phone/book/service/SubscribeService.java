package com.phone.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phone.book.model.Subscribe;
import com.phone.book.reposistory.SubscribeReposistory;

@Service
public class SubscribeService {

	@Autowired
	SubscribeReposistory subscribeReposistory;
	
	public Subscribe saveInfo(Subscribe subscribe)
	{
		subscribe=subscribeReposistory.save(subscribe);
		
		return subscribe;
	}
	
	public List<Subscribe> findAllrecords()
	{
		return subscribeReposistory.findAll();
	}
	public  List<Subscribe> findone(Long id)
	{
		return subscribeReposistory.findByid(id);
	}
}
