package com.bactwo.todolistserver.controller;

import com.bactwo.todolistserver.dto.TodoItemDTO;
import com.bactwo.todolistserver.service.TodoItemService;
import com.bactwo.todolistserver.service.TodoItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/todolist/v1")
public class TodoListRestController {

    private final TodoItemService todoItemService;

    @Autowired
    public TodoListRestController(TodoItemServiceImpl todoItemService) {
        this.todoItemService = todoItemService;
    }

    @PostMapping ( "/new")
    public ResponseEntity<TodoItemDTO> createNewTodoItem (@RequestBody String task) {
        HttpHeaders headers = new HttpHeaders();
        try {
            TodoItemDTO todoItemDTO = todoItemService.createNewTodoItem(task);
             if(todoItemDTO != null) return new ResponseEntity<>(todoItemDTO, headers, HttpStatus.CREATED);
             else return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<TodoItemDTO> getTodoItem (@PathVariable Long id) {
        HttpHeaders headers = new HttpHeaders();
        try {
            TodoItemDTO todoItemDTO = todoItemService.getTodoItem(id);
            if(todoItemDTO != null) return new ResponseEntity<>(todoItemDTO, headers, HttpStatus.OK);
            else return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<TodoItemDTO>> getAllTodoItems () {
        HttpHeaders headers = new HttpHeaders();
        try {
            List<TodoItemDTO> allTodoItemDTOs = todoItemService.getAllTodoItems();
            if(allTodoItemDTOs != null) return new ResponseEntity<>(allTodoItemDTOs, headers, HttpStatus.OK);
            else return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateTodoItem (@RequestBody TodoItemDTO todoItemDTO) {
        HttpHeaders headers = new HttpHeaders();
        try {
            boolean updateSucceeded = todoItemService.updateTodoItemTask(todoItemDTO);
            if(updateSucceeded) return new ResponseEntity<>(true, headers, HttpStatus.OK);
            else return new ResponseEntity<>(false, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(false, headers, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/complete/{id}")
    public ResponseEntity<Boolean> completeTodoItem (@PathVariable Long id) {
        HttpHeaders headers = new HttpHeaders();
        try {
            boolean completionSucceeded = todoItemService.completeTodoItem(id);
            if(completionSucceeded) return new ResponseEntity<>(true, headers, HttpStatus.OK);
            else return new ResponseEntity<>(false, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(false, headers, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteTodoItem (@PathVariable Long id) {
        HttpHeaders headers = new HttpHeaders();
        try {
            boolean deletionSucceeded = todoItemService.deleteTodoItem(id);
            if(deletionSucceeded) return new ResponseEntity<>(true, headers, HttpStatus.OK);
            else return new ResponseEntity<>(false, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(false, headers, HttpStatus.BAD_REQUEST);
        }
    }
}
