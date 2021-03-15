package com.bactwo.todolistserver.dao;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoItemId;

    @Column
    private String task;

    @Column
    private boolean isCompleted;

    @Column
    private LocalDate dateOfTaskCreation;

    @Column
    private LocalDate dateOfTaskCompletion;

    public TodoItem() { }

    public TodoItem(String task, boolean isCompleted,
                    LocalDate dateOfTaskCreation, LocalDate dateOfTaskCompletion) {
        this.task = task;
        this.isCompleted = isCompleted;
        this.dateOfTaskCreation = dateOfTaskCreation;
        this.dateOfTaskCompletion = dateOfTaskCompletion;
    }

    public Long getTodoItemId() {
        return todoItemId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public LocalDate getDateOfTaskCreation() {
        return dateOfTaskCreation;
    }

    public void setDateOfTaskCreation(LocalDate dateOfTaskCreation) {
        this.dateOfTaskCreation = dateOfTaskCreation;
    }

    public LocalDate getDateOfTaskCompletion() {
        return dateOfTaskCompletion;
    }

    public void setDateOfTaskCompletion(LocalDate dateOfTaskCompletion) {
        this.dateOfTaskCompletion = dateOfTaskCompletion;
    }
}
