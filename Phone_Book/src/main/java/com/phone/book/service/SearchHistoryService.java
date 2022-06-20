package com.phone.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phone.book.model.SearchHistory;
import com.phone.book.reposistory.SearchHistoryRepos;

@Service
public class SearchHistoryService {

	
	@Autowired
	SearchHistoryRepos searchHistoryRepos;
	
	public  SearchHistory saveSearchHistory(SearchHistory searchHistory)
	{
		return searchHistoryRepos.save(searchHistory);
	}
}
