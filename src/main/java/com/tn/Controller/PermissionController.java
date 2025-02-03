package com.tn.Controller;

import com.tn.Entity.Permission;
import com.tn.Entity.Role;
import com.tn.Req.Rolereq;
import com.tn.Service.PermissionServiceimp;
import com.tn.Service.RolePermissionService;
import com.tn.Service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Api(value = "Permission Management", description = "Quản lý quyền")
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionServiceimp permissionService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "Tạo quyền", response = ResponseEntity.class)
    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping()
    public void create(@RequestBody Permission permission) {
        permissionService.save(permission);
    }

    @ApiOperation(value = "Xóa quyền", response = ResponseEntity.class)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        permissionService.delete(id);
    }

    @ApiOperation(value = "Thêm quyền cho vai trò", response = ResponseEntity.class)
    @PostMapping("/role")
    public void perForRole(@RequestBody Rolereq rolePermissionReq){
        Role role = new Role();
        Set<Integer> strPer = rolePermissionReq.getPermissionIds();
        Set<Permission> permissions = new HashSet<>();
        strPer.forEach(per -> {
            Permission permission = permissionService.findByRolename(per);
            permissions.add(permission);
        });
        role.setId(rolePermissionReq.getRoleId());
        role.setPermissions(permissions);

        roleService.save(role);
    }
}

