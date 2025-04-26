package com.mm_cinema.employee.view_model.role;

import com.mm_cinema.employee.model.Role;

import java.util.List;
import java.util.stream.Collectors;

public record ListRoleVM(List<RoleVm> roles) {

    public static ListRoleVM fromListRolesEntity(List<Role> roleEntities) {
        List<RoleVm> roleVms = roleEntities.stream()
                .map(RoleVm::fromModel)
                .collect(Collectors.toList());
        return new ListRoleVM(roleVms);
    }
}
