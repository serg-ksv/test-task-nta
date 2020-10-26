package com.ksv.springboottask.repository;

import com.ksv.springboottask.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
