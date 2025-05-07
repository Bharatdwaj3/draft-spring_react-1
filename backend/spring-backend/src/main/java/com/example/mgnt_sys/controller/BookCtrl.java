package com.example.mgnt_sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mgnt_sys.service.BookLoader;;

@Controller
public class BookCtrl {
    @Autowired
    private BookLoader bookLoader;

    @GetMapping("/load-bboks")
    @ResponseBody
    public String loadBook(){
        bookLoader.loadBooks();
        return "Gotcha y'All Books!!";
    }
}
