package com.data.project_webjava.service;

import com.data.project_webjava.entity.Admin;
import com.data.project_webjava.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepo;

    @Override
    public Admin login(String username, String password) {
        return adminRepo.findByUsernameAndPassword(username, password);
    }
}
