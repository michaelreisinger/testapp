package com.bactwo.authserver.service;

import com.bactwo.authserver.client.ResourceAPI;
import com.bactwo.authserver.client.ResourceAPIImpl;
import com.bactwo.authserver.dto.ListOfTodoItemsDTO;
import com.bactwo.authserver.dto.TodoItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TodoListServiceImpl implements TodoListService {

    private final ResourceAPI resourceAPI;

    private final String resourceLocation = "http://localhost:8083/resource/v1/todolist";

    @Autowired
    public TodoListServiceImpl(ResourceAPIImpl resourceAPI) {
        this.resourceAPI = resourceAPI;
    }

    public TodoItemDTO createNewTodoItem (String task) throws Exception {
        String path = "/new";
        ResponseEntity<TodoItemDTO> response = resourceAPI.exchangeRemotePostOrPut(resourceLocation, path,
                HttpMethod.POST, task, TodoItemDTO.class);
        return response.getBody();
    }

    public TodoItemDTO getTodoItem (Long id) throws Exception {
        String path = "/todo/" + id.toString();
        ResponseEntity<TodoItemDTO> response = resourceAPI.getRemoteEntity(resourceLocation,
                path, TodoItemDTO.class);
        return response.getBody();
    }

    public List<TodoItemDTO> getAllTodoItems () throws Exception {
        String path = "/all";
        ResponseEntity<ListOfTodoItemsDTO> response = resourceAPI.getRemoteEntity(resourceLocation, path,
                ListOfTodoItemsDTO.class);
        return  Objects.requireNonNull(response.getBody()).getTodoItemDTOList();
    }

    public Boolean updateTodoItem (TodoItemDTO todoItemDTO) throws Exception {
        String path = "/update";
        ResponseEntity<Boolean> response = resourceAPI.exchangeRemotePostOrPut(resourceLocation, path, HttpMethod.PUT,
                todoItemDTO, Boolean.class);
        return response.getBody();
    }

    public Boolean completeTodoItem (Long id) throws Exception {
        String path = "/complete/" + id.toString();
        ResponseEntity<Boolean> response = resourceAPI.exchangeRemotePostOrPut(resourceLocation, path, HttpMethod.PUT,
                null, Boolean.class);
        return response.getBody();
    }

    public Boolean deleteTodoItem (Long id)  throws Exception {
        String path = "/delete/" + id.toString();
        ResponseEntity<Boolean> response = resourceAPI.exchangeRemoteGetOrDelete(resourceLocation, path,
                HttpMethod.DELETE, Boolean.class);
        return response.getBody();
    }
}
