package com.mm_cinema.employee.service;

import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.employee.view_model.role.RoleVm;
import com.mm_cinema.employee.view_model.role.UpdateRoleVm;
import org.springframework.data.domain.Pageable;

public interface IRoleService {
    RoleVm getRoleDetail(Long id);

    void updateRole(UpdateRoleVm roleVm);

    CollectionsResp getAllRoles(Pageable pageable);

    void updateStatusById(Long id, int status);

}
