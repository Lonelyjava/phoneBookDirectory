package com.phone.book.reposistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phone.book.model.Subscribe;

@Repository
public interface SubscribeReposistory extends JpaRepository<Subscribe, Long>{

	List<Subscribe> findByid(@Param("id")Long id);

}
