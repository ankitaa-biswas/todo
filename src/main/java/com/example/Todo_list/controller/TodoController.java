package com.example.Todo_list.controller;


import com.example.Todo_list.entity.Todo;
import com.example.Todo_list.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.ErrorManager;

@RestController
@RequestMapping("/api/todos")
public class TodoController
{
    @Autowired
    private TodoService todoService;
@GetMapping
    public List<Todo> getAllTodos(){
    return todoService.getAllTodos();

}
@GetMapping("/{id}")
    public ResponseEntity<?> getTodosById(@PathVariable Long id){
    Optional<Todo> todo = todoService.getTodosById(id);
    return todo.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
}
@PostMapping
    public ResponseEntity<?> createTodo(@RequestBody Todo todo){
    try{
        Todo createdTodo=todoService.createTodo(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }
catch(Exception e){
    return new ResponseEntity<>("An error occurred while creating the Todo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        try {
            Todo updatedTodo = todoService.updateTodo(id, todo);
            return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while updating the Todo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id){
    todoService.deleteTodo(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

}

