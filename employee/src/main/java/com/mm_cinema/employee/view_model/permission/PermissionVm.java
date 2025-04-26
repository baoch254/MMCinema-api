package com.mm_cinema.employee.view_model.permission;

import com.mm_cinema.employee.model.Permission;

public record PermissionVm(
        Long id,
        int status,
        String title
) {
    public static PermissionVm fromModel(Permission permission) {
        return new PermissionVm(
                permission.getId(),
                permission.getStatus(),
                permission.getTitle());
    }
}
