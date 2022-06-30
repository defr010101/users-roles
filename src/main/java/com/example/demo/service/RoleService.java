package com.example.demo.service;

import com.example.demo.entity.RoleEntity;
import com.example.demo.exception.RoleAlreadyExistException;
import com.example.demo.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;

    public RoleEntity addRole(RoleEntity role) throws RoleAlreadyExistException {
        if (!(roleRepo.findByName(role.getName()) == null)) {
            throw new RoleAlreadyExistException("Такая роль уже существует");
        }
        return roleRepo.save(role);
    }
}
