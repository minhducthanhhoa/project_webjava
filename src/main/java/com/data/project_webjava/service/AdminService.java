package com.data.project_webjava.service;

import com.data.project_webjava.entity.Admin;

public interface AdminService {
    Admin login(String username, String password);
}
