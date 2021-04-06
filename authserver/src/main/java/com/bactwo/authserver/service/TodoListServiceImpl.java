package com.bactwo.authserver.service;

import com.bactwo.authserver.client.ResourceAPI;
import com.bactwo.authserver.client.ResourceAPIImpl;
import com.bactwo.authserver.dto.TodoItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService {

    private final ResourceAPI resourceAPI;

    private final String resourceLocation = "http://localhost:8083/resource/v1/todolist";

    @Autowired
    public TodoListServiceImpl(ResourceAPIImpl resourceAPI) {
        this.resourceAPI = resourceAPI;
    }

    @Override
    public String test() {
        String path = "/test";
        return resourceAPI.getRemoteEntity(resourceLocation, path, String.class).getBody();
    }

    @Override
    public TodoItemDTO createNewTodoItem (String task) throws Exception {
        String path = "/new";
        ResponseEntity<TodoItemDTO> response = resourceAPI.exchangeRemotePostOrPut(resourceLocation, path,
                HttpMethod.POST, task, TodoItemDTO.class);
        return response.getBody();
    }

    @Override
    public TodoItemDTO getTodoItem (Long id) throws Exception {
        String path = "/todo/" + id.toString();
        ResponseEntity<TodoItemDTO> response = resourceAPI.getRemoteEntity(resourceLocation,
                path, TodoItemDTO.class);
        return response.getBody();
    }

    @Override
    public List<TodoItemDTO> getAllTodoItems () throws Exception {
        String path = "/all";
        List<TodoItemDTO> todoItemDTOList = Arrays.asList(resourceAPI.getRemoteListOfTodos(resourceLocation, path).getBody());
        return todoItemDTOList;
    }

    @Override
    public Boolean updateTodoItem (TodoItemDTO todoItemDTO) throws Exception {
        String path = "/update";
        ResponseEntity<Boolean> response = resourceAPI.exchangeRemotePostOrPut(resourceLocation, path, HttpMethod.PUT,
                todoItemDTO, Boolean.class);
        return response.getBody();
    }

    @Override
    public Boolean completeTodoItem (Long id) throws Exception {
        String path = "/complete/" + id.toString();
        ResponseEntity<Boolean> response = resourceAPI.exchangeRemotePostOrPut(resourceLocation, path, HttpMethod.PUT,
                null, Boolean.class);
        return response.getBody();
    }

    @Override
    public Boolean deleteTodoItem (Long id)  throws Exception {
        String path = "/delete/" + id.toString();
        ResponseEntity<Boolean> response = resourceAPI.exchangeRemoteGetOrDelete(resourceLocation, path,
                HttpMethod.DELETE, Boolean.class);
        return response.getBody();
    }
}
