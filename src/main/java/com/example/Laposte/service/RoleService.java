package com.example.Laposte.service;

import com.example.Laposte.model.Role;
import com.example.Laposte.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role addRole(Role role) {
        try{
            return roleRepository.save(role);
        }catch (Exception e){
            throw e;
        }
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
    public Role updateRoleById(Long id,Role role) {
        Role roleExiste = roleRepository.findById(id).orElse(null);

        if(roleExiste != null) {
          //  Role role = roleExiste.get();
            roleExiste.setLibelle(role.getLibelle());
            roleRepository.save(roleExiste);
        }
        return   null;
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
