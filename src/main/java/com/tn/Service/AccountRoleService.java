package com.tn.Service;

import com.tn.Entity.account;
import com.tn.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AccountRoleService implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<account> getAll() {
        return null;
    }

    @Override
    public Optional<account> findById(Integer id) {
        return Optional.empty();
    }

    public account save(account account){
        accountRepository.save(account);
        return account;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}