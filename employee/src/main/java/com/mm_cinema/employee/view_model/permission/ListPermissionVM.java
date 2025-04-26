package com.mm_cinema.employee.view_model.permission;

import com.mm_cinema.employee.model.Permission;

import java.util.List;
import java.util.stream.Collectors;

public record ListPermissionVM(List<PermissionVm> permissions) {

    public static ListPermissionVM fromListRolesEntity(List<Permission> permissionEntities) {
        List<PermissionVm> permissionVms = permissionEntities.stream()
                .map(PermissionVm::fromModel)
                .collect(Collectors.toList());
        return new ListPermissionVM(permissionVms);
    }
}
