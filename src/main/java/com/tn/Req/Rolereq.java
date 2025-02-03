package com.tn.Req;

import com.tn.Entity.Permission;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class Rolereq {

        private Long roleId;

        private Set<Integer> permissionIds;
}
