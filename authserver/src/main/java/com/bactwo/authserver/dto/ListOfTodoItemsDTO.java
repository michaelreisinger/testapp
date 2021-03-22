package com.bactwo.authserver.dto;

import java.util.ArrayList;
import java.util.List;

public class ListOfTodoItemsDTO {

    private List<TodoItemDTO> todoItemDTOList;

    public ListOfTodoItemsDTO() {
        todoItemDTOList = new ArrayList<>();
    }

    public ListOfTodoItemsDTO(List<TodoItemDTO> todoItemDTOList) {
        this.todoItemDTOList = todoItemDTOList;
    }

    public List<TodoItemDTO> getTodoItemDTOList() {
        return todoItemDTOList;
    }

    public void setTodoItemDTOList(List<TodoItemDTO> todoItemDTOList) {
        this.todoItemDTOList = todoItemDTOList;
    }
}
