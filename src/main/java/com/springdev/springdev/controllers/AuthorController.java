package com.springdev.springdev.controllers;

import com.springdev.springdev.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by oleht on 08.12.2017
 */
@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {

        model.addAttribute("authorData", authorRepository.findAll());

        return "authorsTemplate";
    }

    @RequestMapping("/test")
    public @ResponseBody String getTest() {
        return "test";
    }
}
