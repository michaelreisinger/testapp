package com.bactwo.todolistserver.dao;

import com.bactwo.todolistserver.dto.TodoItemDTO;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDtoMatcher {

    public TodoItemDtoMatcher() { }

    public TodoItem convertTodoItemDtoToDao (TodoItemDTO todoItemDTO) {
        return new TodoItem(todoItemDTO.getTask(), todoItemDTO.isCompleted(),
                todoItemDTO.getDateOfTaskCreation(), todoItemDTO.getDateOfTaskCompletion());
    }

    public TodoItemDTO convertTodoItemDaoToDto (TodoItem todoItem) {
        return new TodoItemDTO(todoItem.getTodoItemId(), todoItem.getTask(), todoItem.isCompleted(),
                todoItem.getDateOfTaskCreation(), todoItem.getDateOfTaskCompletion());
    }
}
