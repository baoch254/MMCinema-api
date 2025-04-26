package com.mm_cinema.employee.view_model.role;

import com.mm_cinema.employee.model.Role;

public record UpdateRoleVm(
        Long id,
        int status,
        String title
) {
    public Role toRole() {
        return Role.builder()
                .id(id)
                .status(status)
                .title(title)
                .build();
    }
}