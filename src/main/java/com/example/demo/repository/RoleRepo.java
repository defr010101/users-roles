package com.example.demo.repository;

import com.example.demo.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);
}
