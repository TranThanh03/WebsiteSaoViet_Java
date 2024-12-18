package com.websitesaoviet.WebsiteSaoViet.repository;

import com.websitesaoviet.WebsiteSaoViet.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    boolean existsAccountBySdt(String sdt);
    boolean existsAccountByEmail(String email);
    Optional<Account> findAccountBySdt(String sdt);
    Optional<Account> findAccountByEmail(String email);
}
