package com.phone.book.reposistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phone.book.model.PhoneBook;

@Repository
public interface MobileNumCheckRepository extends JpaRepository<PhoneBook,Long> {

	
//	@Query(" from PhoneBook p where p.mobile=:mobile")
//	List<PhoneBook> checkMobile(@Param("mobile")String mobile);
}
