package by.lask.spring.boot_security.demo.service;

import by.lask.spring.boot_security.demo.model.Role;
import by.lask.spring.boot_security.demo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Role> findAll() {
        return new HashSet<>(roleRepository.findAll());
    }

}
