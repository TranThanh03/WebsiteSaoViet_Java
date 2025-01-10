package com.websitesaoviet.WebsiteSaoViet.repository;

import com.websitesaoviet.WebsiteSaoViet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT MAX(u.id) FROM User u")
    String findMaxId();
    boolean existsUserByPhone(String phone);
    boolean existsUserByEmail(String email);
    Optional<User> findUserByPhone(String phone);
    Optional<User> findUserByEmail(String email);
}
