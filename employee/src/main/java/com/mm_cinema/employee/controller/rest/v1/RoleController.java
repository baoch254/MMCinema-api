package com.mm_cinema.employee.controller.rest.v1;

import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import com.mm_cinema.employee.service.impl.RoleService;
import com.mm_cinema.employee.view_model.role.RoleVm;
import com.mm_cinema.employee.view_model.role.UpdateRoleVm;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleDetail(@PathVariable Long id) {
        RoleVm role = roleService.getRoleDetail(id);
        return ResponseUtil.successWithData(role, "Role retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateRole(@Valid @RequestBody UpdateRoleVm roleVm) {
        roleService.updateRole(roleVm);
        return ResponseUtil.success("Role updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllRoles(Pageable pageable) {
        CollectionsResp roles = roleService.getAllRoles(pageable);
        return ResponseUtil.successWithCollection(roles);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStatusRole(@PathVariable Long id, @RequestParam int status) {
        roleService.updateStatusById(id, status);
        return ResponseUtil.success("Status Role updated successfully");
    }
}
