package com.phone.book.reposistory;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phone.book.model.PhoneBook;

public interface PhonePbookRepos extends JpaRepository<PhoneBook, Long>{
	List<PhoneBook> findByMobile(String mobile);
	
	List<PhoneBook> findByfname(String fname);
	
//	List<PhoneBook> findByPhonebook_id(long ids);

	@Query("select cn from PhoneBook  cn where  cn.register_date>=:fromDate and cn.register_date<=:toDate")
	List<PhoneBook> getRecords(@Param("fromDate")Date fromDate,@Param("toDate")Date toDate);
	
	@Query("from PhoneBook  cn where  cn.phonebook_id =:id")
	List<PhoneBook> getDetailsById(@Param("id")long id );


}