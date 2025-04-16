package com.example.manki.controller;

import com.example.manki.model.Book;
import com.example.manki.service.BookService;
import com.example.manki.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tasks")
public class BookController {

    private final BookService taskService;
    
    public BookController(BookService taskService){
        this.taskService=taskService;
    }
    @GetMapping
    public ResponseEntity<List<Book>> getAllTasks(){
        List<Book> tasks= taskService.getAllTasks();
        if(tasks.isEmpty()){
            throw new TaskNotFoundException("No tasks found");
        }
        return ResponseEntity.ok(tasks);
    } 
    @GetMapping("/{id}")
    public ResponseEntity<Book> getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id)
        .map(ResponseEntity::ok)
        .orElseThrow(()->new TaskNotFoundException("Task with ID "+id+"not found"));
    }
    @PostMapping
    public ResponseEntity<Book> createTask(@RequestBody Book task){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.addTask(task));
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<Book> updateTaskStatus(@PathVariable Long id, @RequestBody Book updatedTask){
        return taskService.updateTaskStatus(id, updatedTask.isCompleted())
        .map(ResponseEntity::ok)
        .orElseThrow(()->new TaskNotFoundException("Task with ID "+ id+"not found"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        if(!taskService.getTaskById(id).isPresent()){
            throw new TaskNotFoundException("task with ID"+id+"not found");
        }
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
