package com.data.project_webjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String code;

    @NotBlank(message = "Tên sách là bắt buộc")
    @Size(max = 100, message = "Tên sách phải ít hơn 100 ký tự")
    private String title;

    @NotBlank(message = "Tác giả là bắt buộc")
    @Size(max = 50, message = "Tác giả phải ít hơn 50 ký tự")
    private String author;

    @NotBlank(message = "Danh mục là bắt buộc")
    @Size(max = 50, message = "Danh mục phải ít hơn 50 ký tự")
    private String category;

    @Min(value = 0, message = "Số lượng phải ≥ 0")
    private int quantity;

    @Min(value = 1500, message = "Năm xuất bản phải sau năm 1500")
    @Max(value = 2100, message = "Năm xuất bản phải trước năm 2100")
    @Column(name = "publish_year")
    private int publishYear;

    @Size(max = 255, message = "URL hình ảnh phải dưới 255 ký tự")
    private String image;
}
