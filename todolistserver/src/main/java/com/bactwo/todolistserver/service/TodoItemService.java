package com.bactwo.todolistserver.service;

import com.bactwo.todolistserver.dao.TodoItem;
import com.bactwo.todolistserver.dto.TodoItemDTO;

import java.util.List;

public interface TodoItemService {

    List<TodoItemDTO> getAllTodoItems ();

    TodoItemDTO getTodoItem (Long id);

    TodoItemDTO createNewTodoItem (String task);

    boolean completeTodoItem (Long id);

    boolean updateTodoItemTask (TodoItemDTO todoItemDTO);

    boolean deleteTodoItem (Long id);
}
