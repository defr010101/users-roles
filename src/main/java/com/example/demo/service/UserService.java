package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (!(userRepo.findByUsername(user.getUsername()) == null)) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }

    public UserEntity updateInfo(UserEntity user) throws UserNotFoundException {
        if (userRepo.findByUsername(user.getUsername()) == null) {
            throw new UserNotFoundException("Пользователь не был найден");
        }
        return userRepo.save(user);
    }

    public void delete(UserEntity user) throws UserNotFoundException {
        if (userRepo.findByUsername(user.getUsername()) == null) {
            throw new UserNotFoundException("Пользователь не был найден");
        }
        userRepo.delete(user);
    }
}
