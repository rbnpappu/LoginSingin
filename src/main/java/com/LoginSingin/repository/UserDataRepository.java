package com.LoginSingin.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.LoginSingin.entity.RegisterUser;


@Repository
public interface UserDataRepository extends CrudRepository<RegisterUser, Long> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM RegisterUser u WHERE u.name = :name")
    boolean existsByName(String name);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM RegisterUser u WHERE u.password = :password")
    boolean existsByPassword(String password);

	RegisterUser findByName(String name);
}
