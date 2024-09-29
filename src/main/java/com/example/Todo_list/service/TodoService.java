package com.example.Todo_list.service;

import com.example.Todo_list.entity.Todo;
import com.example.Todo_list.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
@Autowired
    private TodoRepository todoRepository;
public List<Todo> getAllTodos(){
    return todoRepository.findAll();

}
public Optional<Todo> getTodosById(Long id){
    return todoRepository.findById(id);


}
public Todo createTodo(Todo todo){
    return todoRepository.save(todo);
}
    public Todo updateTodo(Long id, Todo updatedTodo) {
        return todoRepository.findById(id).map(todo -> {
            todo.setTask(updatedTodo.getTask());
            todo.setCompleted(updatedTodo.isCompleted());
            todo.setDueDate(updatedTodo.getDueDate());
            return todoRepository.save(todo);
        }).orElseGet(() -> {
            updatedTodo.setId(id);
            return todoRepository.save(updatedTodo);
        });
    }
public void deleteTodo(Long id){
    todoRepository.deleteById(id);
}

}
