package com.websitesaoviet.WebsiteSaoViet.repository;

import com.websitesaoviet.WebsiteSaoViet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.sdt = :sdt")
    boolean existsUserBySDT(@Param("sdt")String sdt);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email")
    boolean existsUserByEmail(@Param("email")String email);

    @Query("SELECT u FROM User u WHERE u.sdt = :sdt")
    Optional<User> findUserBySDT(@Param("sdt")String sdt);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findUserByEmail(@Param("email")String email);
}
