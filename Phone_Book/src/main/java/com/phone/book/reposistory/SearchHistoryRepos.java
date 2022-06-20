package com.phone.book.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phone.book.model.SearchHistory;

public interface SearchHistoryRepos extends JpaRepository<SearchHistory, Long> {

}
