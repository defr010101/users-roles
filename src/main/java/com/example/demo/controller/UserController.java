package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity register(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь был успешно зарегистрирован");
        } catch (UserAlreadyExistException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PatchMapping
    public ResponseEntity updateInfo(@RequestBody UserEntity user) {
        try {
            userService.updateInfo(user);
            return ResponseEntity.ok("Информация обновлена");
        } catch (UserNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestBody UserEntity user) {
        try {
            userService.delete(user);
            return ResponseEntity.ok("Пользователь был успешно удалён");
        } catch (UserNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
