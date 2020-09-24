package sn.devopsteam2.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.devopsteam2.todolist.domain.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
