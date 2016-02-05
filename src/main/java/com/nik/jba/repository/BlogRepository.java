package com.nik.jba.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nik.jba.entity.Blog;
import com.nik.jba.entity.User;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{

	List<Blog> findByUser(User u);
	


	
}
