package com.example.mgnt_sys.service;

import com.example.mgnt_sys.model.Book;
import com.example.mgnt_sys.repository.BookRepository;

/*import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;*/
import java.util.List;
import java.util.Optional;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Optional<Book> getBookuById(Long id){
        return bookRepository.findById(id);
    }
    public Book addBooku(Book book){
        return bookRepository.save(book);
    }

    public Optional<Book> updateBookStatus(Long id, boolean completed){
        return bookRepository.findById(id).map(Book -> {
            Book.setCompleted(completed);
            return bookRepository.save(Book);
        });
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
