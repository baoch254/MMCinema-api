package com.mm_cinema.employee.service.impl;

import com.mm_cinema.common_library.exception.NotFoundException;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.model.Pagination;
import com.mm_cinema.employee.model.Role;
import com.mm_cinema.employee.repository.RoleRepository;
import com.mm_cinema.employee.service.IRoleService;
import com.mm_cinema.employee.utils.Constants;
import com.mm_cinema.employee.view_model.role.RoleVm;
import com.mm_cinema.employee.view_model.role.UpdateRoleVm;
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
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleVm getRoleDetail(Long id) {
        Role role = roleRepository.findById(id).orElse(new Role());
        return RoleVm.fromModel(role);
    }

    @Override
    public void updateRole(UpdateRoleVm roleVm) {

        Role role = getRoleById(roleVm.id());
        // Update logic validate and mapping employeeVm Update vs Existed ...

        // Basic mapping
        role.setStatus(roleVm.status());
        role.setTitle(roleVm.title());
        roleRepository.save(role);
    }


    @Override
    public CollectionsResp getAllRoles(Pageable pageable) {
        Page<Role> rolePage = roleRepository.findAll(pageable);

        List<RoleVm> roleVms = rolePage.getContent().stream()
                .map(RoleVm::fromModel)
                .collect(Collectors.toList());

        Pagination pagination = new Pagination(
                rolePage.getTotalElements(),
                rolePage.getTotalPages(),
                rolePage.getSize(),
                rolePage.getNumber() + 1
        );

        return new CollectionsResp(roleVms, pagination);
    }

    @Override
    public void updateStatusById(Long id, int status) {
        roleRepository.updateStatusById(id, status);
    }

    private Role getRoleById(long roleId) {
        return roleRepository.findById(roleId).orElseThrow(() -> new NotFoundException(Constants.ErrorCode.ROLE_NOT_FOUND, roleId));
    }

}
