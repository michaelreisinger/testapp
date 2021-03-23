package com.bactwo.authserver.service;

import com.bactwo.authserver.dto.TodoItemDTO;

import java.util.List;

public interface TodoListService {

    String test();

    TodoItemDTO createNewTodoItem (String task) throws Exception;

    TodoItemDTO getTodoItem (Long id) throws Exception;

    List<TodoItemDTO> getAllTodoItems () throws Exception;

    Boolean updateTodoItem (TodoItemDTO todoItemDTO) throws Exception;

    Boolean completeTodoItem (Long id) throws Exception;

    Boolean deleteTodoItem (Long id)  throws Exception;

}
