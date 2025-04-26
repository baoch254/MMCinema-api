package com.mm_cinema.employee.service.impl;

import com.mm_cinema.common_library.exception.NotFoundException;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.model.Pagination;
import com.mm_cinema.employee.model.Permission;
import com.mm_cinema.employee.repository.PermissionRepository;
import com.mm_cinema.employee.service.IPermissionService;
import com.mm_cinema.employee.utils.Constants;
import com.mm_cinema.employee.view_model.permission.PermissionVm;
import com.mm_cinema.employee.view_model.permission.UpdatePermissionVm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class PermissionService implements IPermissionService {
    private final PermissionRepository permissionRepository;

    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public PermissionVm getPermissionDetail(Long id) {
        Permission permission = permissionRepository.findById(id).orElse(new Permission());
        return PermissionVm.fromModel(permission);
    }

    @Override
    public void updatePermission(UpdatePermissionVm permissionVm) {

        Permission permission = getPermissionById(permissionVm.id());
        // Update logic validate and mapping employeeVm Update vs Existed ...

        // Basic mapping
        permission.setStatus(permissionVm.status());
        permission.setTitle(permissionVm.title());
        permissionRepository.save(permission);
    }


    @Override
    public CollectionsResp getAllPermissions(Pageable pageable) {
        Page<Permission> permissionPage = permissionRepository.findAll(pageable);

        List<PermissionVm> permissionVms = permissionPage.getContent().stream()
                .map(PermissionVm::fromModel)
                .collect(Collectors.toList());

        Pagination pagination = new Pagination(
                permissionPage.getTotalElements(),
                permissionPage.getTotalPages(),
                permissionPage.getSize(),
                permissionPage.getNumber() + 1
        );

        return new CollectionsResp(permissionVms, pagination);
    }

    @Override
    public void updateStatusById(Long id, int status) {
        permissionRepository.updateStatusById(id, status);
    }

    private Permission getPermissionById(long permissionId) {
        return permissionRepository.findById(permissionId).orElseThrow(() -> new NotFoundException(Constants.ErrorCode.PERMISSION_NOT_FOUND, permissionId));
    }

}
