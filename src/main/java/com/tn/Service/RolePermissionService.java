package com.tn.Service;

import com.tn.Entity.RolePermission;
import com.tn.Entity.account;
import com.tn.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionService {
    @Autowired
    static RoleRepository roleRepository;

    public void save(RolePermission rolePermission) {
    }


}
