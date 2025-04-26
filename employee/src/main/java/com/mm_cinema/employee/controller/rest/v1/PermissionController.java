package com.mm_cinema.employee.controller.rest.v1;

import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import com.mm_cinema.employee.service.impl.PermissionService;
import com.mm_cinema.employee.view_model.permission.PermissionVm;
import com.mm_cinema.employee.view_model.permission.UpdatePermissionVm;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPermissionDetail(@PathVariable Long id) {
        PermissionVm permission = permissionService.getPermissionDetail(id);
        return ResponseUtil.successWithData(permission, "Permission retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updatePermission(@Valid @RequestBody UpdatePermissionVm permissionVm) {
        permissionService.updatePermission(permissionVm);
        return ResponseUtil.success("Permission updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllPermissions(Pageable pageable) {
        CollectionsResp permissions = permissionService.getAllPermissions(pageable);
        return ResponseUtil.successWithCollection(permissions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStatusPermission(@PathVariable Long id, @RequestParam int status) {
        permissionService.updateStatusById(id, status);
        return ResponseUtil.success("Status Permission updated successfully");
    }
}
