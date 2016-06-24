package com.repository;

import com.entity.MusicAlbom;
import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@Transactional
public interface UserRepository extends CrudRepository<User,Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
    User findUserByEmailAndPassword(@RequestParam String emailUser, @RequestParam String password);

    @Query(value = "SELECT u FROM User u WHERE u.id = ?1")
    User findUserById(int id);

    @Query(value = "SELECT u FROM User u WHERE u.email =:email")
    User findOneByEMail(@Param("email") String email);

    @Query(value = "SELECT u FROM User u WHERE u.firstName =:firstname")
    User findOneByUserName(@Param("firstname") String firstname);

    @Query(value = "SELECT u FROM User u WHERE (u.id LIKE concat(:id))")
    MusicAlbom findAlbomMusicBuIdUser(@Param("id") int id);



}