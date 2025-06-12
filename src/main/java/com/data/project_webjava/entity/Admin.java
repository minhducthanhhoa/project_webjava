package com.data.project_webjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Tên đăng nhập không được để trống")
    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Column(nullable = false, length = 255)
    private String password;
}
