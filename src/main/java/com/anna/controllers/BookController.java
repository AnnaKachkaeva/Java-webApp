package com.anna.controllers;

import com.anna.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }

    @GetMapping("/w")
    public String partialRenderView(Model model){
        //ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        String partialRenderString = "Thymeleaf partial render";
        model.addAttribute("partialRenderViewText", partialRenderString);

        return "books/mypage";
    }

}



