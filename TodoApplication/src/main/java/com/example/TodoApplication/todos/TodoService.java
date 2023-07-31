package com.example.TodoApplication.todos;



import com.example.TodoApplication.error.ConflictException;
import com.example.TodoApplication.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {

    @Autowired
    private TodoRepositories repo;
    public Todo getOneTode(int id ){
        try {
            return repo.findById((long) id).get();
        }
        catch (NoSuchElementException ex)
        {
            throw new NotFoundException(String.format("there is no entity with [%d] id in the database",id));
        }
    }
    public List<Todo> getAllTodos() {
        return repo.findAll();
    }

    public Todo addTodo(Todo todo) {

        if (repo.findByTitle(todo.getTitle())!=null)
        {
            throw new ConflictException(String.format("this title [%s] actual exist ", todo.getTitle()));
        }
        return repo.save(todo);
    }

    public void deleteTodo(int id) {
        repo.deleteById((long) id);
    }
}