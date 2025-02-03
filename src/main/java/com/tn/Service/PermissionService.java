package com.tn.Service;

import com.tn.Entity.Permission;
import com.tn.Entity.account;

import java.util.Optional;

public interface PermissionService {
    public void save(Permission permission);

    public void delete(Integer id);

    public Permission findByRolename(Integer per);
    Optional<account> findById(Integer id);
}
