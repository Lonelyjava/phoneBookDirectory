package com.phone.book.reposistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phone.book.model.Master;

public interface MasterRepos extends JpaRepository<Master, Long>{
	List<Master> findAll();

}
