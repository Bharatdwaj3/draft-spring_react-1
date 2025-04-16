package com.example.manki.service;

import org.springframework.stereotype.Service;
import com.example.manki.model.Book;
import com.example.manki.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository taskRepository;
    public BookService(BookRepository taskRepository){
        this.taskRepository=taskRepository;
    }

    public List<Book> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Book> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public Book addTask(Book task){
        return taskRepository.save(task);
    }

    public Optional<Book> updateTaskStatus(Long id, boolean completed){
        return taskRepository.findById(id).map(task->{
            return taskRepository.save(task);
        });
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
