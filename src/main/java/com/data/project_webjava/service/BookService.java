package com.data.project_webjava.service;

import com.data.project_webjava.entity.Book;
import com.data.project_webjava.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public String generateBookCode() {
        long count = bookRepository.count() + 1;
        String code;
        do {
            code = String.format("B%04d", count++);
        } while (bookRepository.existsByCode(code));
        return code;
    }

    public boolean isTitleExist(String title) {
        return bookRepository.existsByTitle(title);
    }
}
