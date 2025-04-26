package com.mm_cinema.employee.view_model.permission;

import com.mm_cinema.employee.model.Permission;

public record UpdatePermissionVm(
        Long id,
        int status,
        String title
) {
    public Permission toPermission() {
        return Permission.builder()
                .id(id)
                .status(status)
                .title(title)
                .build();
    }
}