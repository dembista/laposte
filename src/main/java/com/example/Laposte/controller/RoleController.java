package com.example.Laposte.controller;

import com.example.Laposte.model.Role;
import com.example.Laposte.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/role")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        try{
            return ResponseEntity.ok(roleService.addRole(role));
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/role")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @PutMapping("/role/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {
        return ResponseEntity.ok(roleService.updateRoleById(id, role));
    }

    @DeleteMapping("/role/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
