package com.mm_cinema.employee.view_model.permission;

import com.mm_cinema.employee.model.Permission;

public record GetPermissionDetailVm(
        Long id,
        int status,
        String title
) {
    public static GetPermissionDetailVm fromModel(Permission permission) {
        return new GetPermissionDetailVm(
                permission.getId(),
                permission.getStatus(),
                permission.getTitle());
    }
}
