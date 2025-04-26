package com.mm_cinema.employee.view_model.role;

import com.mm_cinema.employee.model.Role;

public record GetRoleDetailVm(
        Long id,
        int status,
        String title
) {
    public static GetRoleDetailVm fromModel(Role role) {
        return new GetRoleDetailVm(
                role.getId(),
                role.getStatus(),
                role.getTitle());
    }
}
