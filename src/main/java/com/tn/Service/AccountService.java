package com.tn.Service;

import com.tn.Entity.account;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface AccountService extends UserDetailsService {
    List<account> getAll();

    Optional<account> findById(Integer id);

    account save(account account);
}
