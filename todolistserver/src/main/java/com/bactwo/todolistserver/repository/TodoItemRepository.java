package com.bactwo.todolistserver.repository;

import com.bactwo.todolistserver.dao.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository  extends CrudRepository<TodoItem, Long> {
}
