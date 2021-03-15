package com.bactwo.todolistserver.service;

import com.bactwo.todolistserver.dao.TodoItem;
import com.bactwo.todolistserver.dao.TodoItemDtoMatcher;
import com.bactwo.todolistserver.dto.TodoItemDTO;
import com.bactwo.todolistserver.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepository;

    private final TodoItemDtoMatcher todoItemDtoMatcher;

    @Autowired
    public TodoItemServiceImpl(TodoItemRepository todoItemRepository, TodoItemDtoMatcher todoItemDtoMatcher) {
        this.todoItemRepository = todoItemRepository;
        this.todoItemDtoMatcher = todoItemDtoMatcher;
    }

    @Override
    public List<TodoItemDTO> getAllTodoItems() {
        try {
            List<TodoItem> allTodoItems = (List<TodoItem>) todoItemRepository.findAll();
            List<TodoItemDTO> allTodoItemDTOs = new ArrayList<>();
            for (TodoItem todoItem : allTodoItems) {
              TodoItemDTO todoItemDTO = todoItemDtoMatcher.convertTodoItemDaoToDto(todoItem);
              allTodoItemDTOs.add(todoItemDTO);
            }
            return allTodoItemDTOs;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    @Override
    public TodoItemDTO getTodoItem(Long id) {
        try {
            TodoItem todoItem = todoItemRepository.findById(id).orElseThrow();
            TodoItemDTO todoItemDTO = todoItemDtoMatcher.convertTodoItemDaoToDto(todoItem);
            return todoItemDTO;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    @Override
    public TodoItemDTO createNewTodoItem(String task) {
        try {
            TodoItem todoItem = new TodoItem(task, false,
                    LocalDate.now(), null);
            todoItemRepository.save(todoItem);
            return todoItemDtoMatcher.convertTodoItemDaoToDto(todoItem);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    @Override
    public boolean completeTodoItem(Long id) {
        try {
            TodoItem todoItem = todoItemRepository.findById(id)
                    .orElseThrow();
            todoItem.setCompleted(true);
            todoItem.setDateOfTaskCompletion(LocalDate.now());
            todoItemRepository.save(todoItem);
            return true;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return false;
        }
    }

    @Override
    public boolean updateTodoItemTask(TodoItemDTO todoItemDTO) {
        try {
            TodoItem todoItem = todoItemRepository.findById(todoItemDTO.getTodoITemId())
                    .orElseThrow();
            todoItem.setTask(todoItemDTO.getTask());
            todoItemRepository.save(todoItem);
            return true;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return false;
        }
    }

    @Override
    public boolean deleteTodoItem(Long id) {
        try {
            todoItemRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return false;
        }
    }
}
