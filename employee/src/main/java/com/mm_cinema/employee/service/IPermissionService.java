package com.mm_cinema.employee.service;

import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.employee.view_model.permission.PermissionVm;
import com.mm_cinema.employee.view_model.permission.UpdatePermissionVm;
import org.springframework.data.domain.Pageable;

public interface IPermissionService {
    PermissionVm getPermissionDetail(Long id);

    void updatePermission(UpdatePermissionVm permissionVm);

    CollectionsResp getAllPermissions(Pageable pageable);

    void updateStatusById(Long id, int status);

}
