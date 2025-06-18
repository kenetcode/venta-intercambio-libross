package com.ues.edu.sivil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ues.edu.sivil.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.email =:email")
	public User loadUserByUserName(@Param("email") String email);
	
	@Query(value = "select * from users", nativeQuery = true)
	public List<User> getUsers();

}
	