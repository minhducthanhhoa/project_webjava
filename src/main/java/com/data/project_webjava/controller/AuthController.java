package com.data.project_webjava.controller;

import com.data.project_webjava.entity.Admin;
import com.data.project_webjava.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AuthController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("admin") Admin admin,
                        BindingResult result,
                        HttpSession session,
                        Model model) {
        if (result.hasErrors()) {
            return "login";
        }

        Admin loggedInAdmin = adminService.login(admin.getUsername(), admin.getPassword());

        if (loggedInAdmin == null) {
            model.addAttribute("loginError", "Tên đăng nhập hoặc mật khẩu không đúng");
            return "login";
        }

        session.setAttribute("admin", loggedInAdmin);
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

}
