package com.phone.book.reposistory;


import org.springframework.data.jpa.repository.JpaRepository;

import com.phone.book.model.SignUp;

public interface SignUpRepos extends JpaRepository<SignUp, Long>{

}
