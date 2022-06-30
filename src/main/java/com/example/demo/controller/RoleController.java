package com.example.demo.controller;

import com.example.demo.entity.RoleEntity;
import com.example.demo.exception.RoleAlreadyExistException;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity addRole(@RequestBody RoleEntity role) {
        try {
            roleService.addRole(role);
            return ResponseEntity.ok().body("Роль успешно добавлена");
        } catch (RoleAlreadyExistException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
