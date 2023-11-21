package by.lask.spring.boot_security.demo.service;

import by.lask.spring.boot_security.demo.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> findAll();

}
