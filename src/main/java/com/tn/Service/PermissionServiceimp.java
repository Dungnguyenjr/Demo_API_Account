package com.tn.Service;

import com.tn.Entity.Permission;
import com.tn.Entity.account;
import com.tn.Repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermissionServiceimp implements PermissionService {
    @Autowired
    PermissionRepository permissionRepository;

    public void save(Permission permission) {
        permissionRepository.save(permission);
    }

    public void delete(Integer id) {
        permissionRepository.deleteById(id);
    }

    @Override
    public Permission findByRolename(Integer per) {
        Optional<Permission> permission = permissionRepository.findById(per);
        return permission.orElse(null);
    }

    @Override
    public Optional<account> findById(Integer id) {
        return Optional.empty();
    }
}
