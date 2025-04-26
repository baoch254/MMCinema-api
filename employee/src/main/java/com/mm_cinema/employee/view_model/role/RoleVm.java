package com.mm_cinema.employee.view_model.role;

import com.mm_cinema.employee.model.Role;

public record RoleVm(
        Long id,
        int status,
        String title
) {
    public static RoleVm fromModel(Role role) {
        return new RoleVm(
                role.getId(),
                role.getStatus(),
                role.getTitle());
    }
}
