package com.example.TodoApplication.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "com/example/TodoApplication")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping(value = {"/",""})
    public ResponseEntity<List<Todo>> listTodos()
    {
        List<Todo> result=todoService.getAllTodos();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> oneTodos(@PathVariable int id)
    {
        Todo todo=todoService.getOneTode(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }
    @PostMapping(value = {"/",""})
    public ResponseEntity<Todo> CreateNewTodo(@RequestBody Todo todo)
    {
        Todo createdTodo=todoService.addTodo(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id)
    {
        todoService.deleteTodo(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }


}