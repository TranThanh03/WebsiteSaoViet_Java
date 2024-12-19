package com.websitesaoviet.WebsiteSaoViet.repository;

import com.websitesaoviet.WebsiteSaoViet.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    @Query("SELECT a FROM Account a WHERE a.SDT = :sdt")
    boolean existsAccountBySDT(@Param("sdt")String sdt);
    @Query("SELECT a FROM Account a WHERE a.Email = :email")
    boolean existsAccountByEmail(@Param("email")String email);
    @Query("SELECT a FROM Account a WHERE a.SDT = :sdt")
    Optional<Account> findAccountBySDT(@Param("sdt")String sdt);
    @Query("SELECT a FROM Account a WHERE a.Email = :email")
    Optional<Account> findAccountByEmail(@Param("email")String email);
}
