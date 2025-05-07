package com.example.mgnt_sys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
     @Id 
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    private String 
        bookName,
        bookGenre,
        bookFileFormat,
        bookWriter,
        bookPublisher;
    private int 
        bookPages,
        bookIsbn;

    private boolean completed;
    
    public Long getId(){return id;}
    
    public String getBookName(){return bookName;}
    public String getBookGenre(){return bookGenre;}
    public String getBookFileFormat(){return bookFileFormat;}
    public String getBookWriter(){return bookWriter;}
    public String getBookPublisher(){return bookPublisher;}
    
    public Integer getBookPages(){return bookPages;}
    public Integer getBookISBN(){return bookIsbn;}

    public boolean getCompleted(){return completed;}

    public void setCompleted(boolean completed){this.completed=completed;}
    public void setId(Long id) {this.id = id;}

    public void setBookName(String bookName){this.bookName = bookName;}
    public void setBookGenre( String bookGenre){this.bookGenre = bookGenre;}
    public void setBookFileFormat(String bookFileFormat){this.bookFileFormat = bookFileFormat;}
    public void setBookWriter(String bookWriter){this.bookWriter = bookWriter;}
    public void setBookPublisher(String bookPublisher){this.bookPublisher = bookPublisher;}
    
    public void setBookPages(int bookPages){this.bookPages= bookPages;}
    public void setBookISBN(int bookIsbn){this.bookIsbn= bookIsbn;}

    public boolean setCompleted(){return completed;}



    
}
