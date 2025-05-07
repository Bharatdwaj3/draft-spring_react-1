package com.example.mgnt_sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;



import org.springframework.stereotype.Controller;

import com.example.mgnt_sys.model.Book;
import com.example.mgnt_sys.repository.BookRepository;

@Controller
public class BookController {

     @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book")
    public String getBook(){
        return "redirect:/book.html";
    }
    @PostMapping("/submitBook")
    @ResponseBody
    public String handleBookSumbmission(
            
            @RequestParam("name") String bookName,
            @RequestParam("genre") String bookGenre,
            @RequestParam("format") String bookFileFormat,
            @RequestParam("writer") String bookWriter,
            @RequestParam("publisher") String bookPublisher,
            @RequestParam("pages") Integer bookPages,
            @RequestParam("isbn") Integer bookISBN
    ){
            Book book = new Book();
            book.setBookName(bookName);
            book.setBookGenre(bookGenre);
            book.setBookFileFormat(bookFileFormat);
            book.setBookWriter(bookWriter);
            book.setBookPublisher(bookPublisher);
            book.setBookPages(bookPages);
            book.setBookISBN(bookISBN);
            book.setCompleted(false);

            bookRepository.save(book);
                        

            return bookName + " by "  + bookWriter +   "is sumbitted as a " +  bookFileFormat +  " of " +  bookPages + " pages and an ISBN id " + bookISBN ;
    } 
}
