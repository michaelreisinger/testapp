package com.bactwo.authserver.dto;

import java.time.LocalDate;

public class TodoItemDTO {

    private Long todoItemId;

    private String task;

    private boolean isCompleted;

    private LocalDate dateOfTaskCreation;

    private LocalDate dateOfTaskCompletion;

    public TodoItemDTO() { }

    public TodoItemDTO(Long todoItemId, String task, boolean isCompleted,
                       LocalDate dateOfTaskCreation, LocalDate dateOfTaskCompletion) {
        this.todoItemId = todoItemId;
        this.task = task;
        this.isCompleted = isCompleted;
        this.dateOfTaskCreation = dateOfTaskCreation;
        this.dateOfTaskCompletion = dateOfTaskCompletion;
    }

    public Long getTodoItemId() {
        return todoItemId;
    }

    public void setTodoItemId(Long todoItemId) {
        this.todoItemId = todoItemId;
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

