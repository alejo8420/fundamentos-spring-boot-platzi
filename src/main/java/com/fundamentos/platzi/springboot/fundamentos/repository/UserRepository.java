package com.fundamentos.platzi.springboot.fundamentos.repository;

import com.fundamentos.platzi.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);
    @Query("select u from User u where u.name like ?1%")
    List<User> findByAndSort(String name, Sort sort);
}
