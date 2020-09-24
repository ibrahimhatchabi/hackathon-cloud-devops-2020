package sn.devopsteam2.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.devopsteam2.todolist.domain.TodoItem;
import sn.devopsteam2.todolist.repository.TodoItemRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoItemController {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @PostMapping("/todolist")
    TodoItem newItem(@RequestBody TodoItem item) {
        return todoItemRepository.save(item);
    }

    @GetMapping("/todolist")
    List<TodoItem> allItem() {
        return todoItemRepository.findAll();
    }

    @GetMapping("/todolist/{id}")
    Optional<TodoItem> oneItem(@PathVariable Long id) {
        return todoItemRepository.findById(id);
    }

    @PutMapping("/todolist/{id}")
    TodoItem replaceTodoItem(@RequestBody TodoItem item, @PathVariable Long id) {

        return todoItemRepository.findById(id)
            .map(itemRecup -> {
                itemRecup.setCompleted(true);
                return todoItemRepository.save(itemRecup);
            })
            .orElseGet(() -> {
                item.setId(id);
                item.setCompleted(true);
                return todoItemRepository.save(item);
            });
    }

    @DeleteMapping("/todolist/{id}")
    void deleteItem(@PathVariable Long id) {
        todoItemRepository.deleteById(id);
    }
}
