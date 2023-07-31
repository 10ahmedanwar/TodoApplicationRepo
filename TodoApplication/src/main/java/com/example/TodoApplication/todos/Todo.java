package com.example.TodoApplication.todos;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "Todo")
public class Todo {

    @Id
    @Column(name = "UserId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Title is required")
    @Size(min = 3, message = "Title must be at least 3 characters long")
    @Column(name = "title")
    private String title;

    @Size(min = 3, message = "Title must be at least 3 characters long")
    @NotNull(message = "Description is required")
    @Column(name = "description")
    private String description;

    public Todo() {
    }

    public Todo(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}