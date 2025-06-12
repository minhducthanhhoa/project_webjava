package com.data.project_webjava.controller;

import com.data.project_webjava.entity.Book;
import com.data.project_webjava.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("book", new Book());
        return "listBook";
    }

    @GetMapping("/add-book")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/save-book")
    public String saveBook(@ModelAttribute("book") @Valid Book book,
                           BindingResult result,
                           RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "addBook";
        }
        book.setCode(bookService.generateBookCode());
        if (bookService.isTitleExist(book.getTitle())) {
            result.rejectValue("title", null, "Tiêu đề đã tồn tại");
            return "addBook";
        }
        bookService.save(book);
        redirectAttributes.addFlashAttribute("success", "Thêm sách thành công!");
        return "redirect:/books";
    }
}
