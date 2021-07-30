package com.bactwo.authserver.controller;

import com.bactwo.authserver.dto.TodoItemDTO;
import com.bactwo.authserver.service.TodoListService;
import com.bactwo.authserver.service.TodoListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/todo-api/v1")
public class TodoListController {

    private final TodoListService todoListService;

    @Autowired
    public TodoListController( TodoListServiceImpl todoListServiceImpl) {
        this.todoListService = todoListServiceImpl;
    }

    @PostMapping( "/new")
    public ResponseEntity<TodoItemDTO> createNewTodoItem (@RequestBody String task) {
        HttpHeaders headers = new HttpHeaders();
        try {
            TodoItemDTO todoItemDTO = todoListService.createNewTodoItem(task);
            if(todoItemDTO != null) return new ResponseEntity<>(todoItemDTO, headers, HttpStatus.CREATED);
            else return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/test")
    public String test () {
        return "test response from first service";
    }

    @GetMapping("/test2")
    public String test2 () {
        return todoListService.test();
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<TodoItemDTO> getTodoItem (@PathVariable Long id) {
        HttpHeaders headers = new HttpHeaders();
        try {
            TodoItemDTO todoItemDTO = todoListService.getTodoItem(id);
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
            List<TodoItemDTO> allTodoItemDTOs = todoListService.getAllTodoItems();
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
            boolean updateSucceeded = todoListService.updateTodoItem(todoItemDTO);
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
            boolean completionSucceeded = todoListService.completeTodoItem(id);
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
            boolean deletionSucceeded = todoListService.deleteTodoItem(id);
            if(deletionSucceeded) return new ResponseEntity<>(true, headers, HttpStatus.OK);
            else return new ResponseEntity<>(false, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(false, headers, HttpStatus.BAD_REQUEST);
        }
    }


}
