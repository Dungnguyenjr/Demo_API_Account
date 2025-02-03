package com.tn.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;
@Table
@Data
public class RolePermission {

    @Column
    private Integer roleId;

    @Column
    private List<Integer> permissionIds;
}
