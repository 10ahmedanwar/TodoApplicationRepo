package com.example.TodoApplication.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TodoRepositories extends JpaRepository<Todo,Long> {
    Todo findByTitle(String title);

}
