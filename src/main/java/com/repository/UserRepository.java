package com.repository;

import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {

    @Query(value = "select u from User u where u.email = ?1 and u.password = ?2")
    User findUserByEmailAndPassword (@RequestParam String emailUser, @RequestParam String password);

    @Query(value = "select u from User u where u.id = ?1")
    User findUserById (int id);


}
