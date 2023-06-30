package com.saulo.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saulo.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
