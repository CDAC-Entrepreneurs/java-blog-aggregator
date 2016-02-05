package com.nik.jba.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nik.jba.entity.User;
@Repository
@Qualifier("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

	 public User save(User user);
	 public User findByName(String username);

	
}
