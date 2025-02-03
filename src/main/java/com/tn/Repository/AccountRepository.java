package com.tn.Repository;

import com.tn.Entity.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface AccountRepository extends JpaRepository <account, Integer> {
    account findByUsername(String username);

    Optional<account> findById(Integer id);



}
