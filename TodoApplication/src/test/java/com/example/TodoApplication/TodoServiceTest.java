package com.example.TodoApplication;


import com.example.TodoApplication.error.NotFoundException;
import com.example.TodoApplication.todos.Todo;
import com.example.TodoApplication.todos.TodoRepositories;
import com.example.TodoApplication.todos.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class TodoServiceTest {
    @MockBean
    private TodoRepositories todoRepo;

    @Autowired
    private TodoService todoservice;

    @TestConfiguration
    static class TodoServiceContextConfiguration
    {
        @Bean
        public TodoService todoService()
        {
            return new TodoService();

        }
    }
    @Test
    public void whengetAllTodos_returnAllTodos(){

        Todo todo1=new Todo(1,"book1","a sample Book1");
        Todo todo2=new Todo(2,"book2","a sample Book2");
        List<Todo> data= Arrays.asList(todo1,todo2);

        given(todoRepo.findAll()).willReturn(data);

        assertThat(todoservice.getAllTodos()).hasSize(2).contains(todo1,todo2);

    }
    @Test
    public void whenGetOneTodo_returnOneTodo()
    {
        //repo.findById(id).
        Todo todo1=new Todo(1,"book1","a sample Book1");

        given(todoRepo.findById((long) anyInt())).willReturn(Optional.ofNullable(todo1));
        Todo result= todoservice.getOneTode(232) ;

        assertThat(result.getTitle()).contains("b");
    }

    @Test(expected = NotFoundException.class)
    public void whenGetOneTodo_TodoShouldNotFound()
    {
        given(todoRepo.findById((long) anyInt())).willReturn(Optional.empty());
        Todo result= todoservice.getOneTode(232) ;
    }



}
