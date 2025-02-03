package com.tn.Controller;

import com.tn.Entity.Role;
import com.tn.Entity.account;
import com.tn.Repository.RoleRepository;
import com.tn.Repository.AccountRepository;
import com.tn.Service.AccountRoleService;
import com.tn.Service.RoleService;
import dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;


@Api(value = "User Management", description = "Quản lý người dùng")
@RestController
@RequestMapping("/user")
public class AccountController {

    @Autowired
    private AccountRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AccountRoleService accountRoleService;

    @ApiOperation(value = "Tạo mới một người dùng", response = ResponseEntity.class)
    @PostMapping("/account")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
        account user = new account();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        Set<String> strRoles = userDTO.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            Role userRole = roleRepository.findByRolename(role);
            roles.add(userRole);
        });

        user.setRoles(roles);
        account savedUser = userRepository.save(user);

        return ResponseEntity.ok(savedUser);
    }

    @ApiOperation(value = "Tạo Role", response = ResponseEntity.class)
    @PostMapping("/role")
    public ResponseEntity<?> createRole(@RequestBody Role role){
        Role savedRole = roleRepository.save(role);
        return ResponseEntity.ok(savedRole);
    }

    @ApiOperation(value = "Xóa Role", response = ResponseEntity.class)
    @DeleteMapping("/role/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Integer id){
        roleRepository.deleteById(id);
        return ResponseEntity.ok("Vai trò đã được xóa thành công");
    }

    @ApiOperation(value = "Cập nhật thông tin người dùng", response = ResponseEntity.class)
    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody account userDetails){
        account user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng: " + id));
        user.setUsername(userDetails.getUsername());
        account updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
}