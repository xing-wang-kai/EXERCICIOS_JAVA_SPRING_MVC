package com.kai.wang.mvc.mudi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kai.wang.mvc.mudi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	
	@Query(value="SELECT * FROM users WHERE username=:name", nativeQuery=true)
	public User findByName(String name);
}
