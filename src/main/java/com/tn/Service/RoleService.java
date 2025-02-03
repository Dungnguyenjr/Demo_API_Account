package com.tn.Service;


import com.tn.Entity.Role;
import com.tn.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService  {

    @Autowired
    private RoleRepository roleRepository;

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Optional<Role> findById(Integer id){
        return roleRepository.findById(id);
    };


    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

}
