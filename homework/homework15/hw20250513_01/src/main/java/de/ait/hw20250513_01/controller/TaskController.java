package de.ait.hw20250513_01.controller;

import de.ait.hw20250513_01.dto.TaskRequestDto;
import de.ait.hw20250513_01.dto.TaskResponseDto;
import de.ait.hw20250513_01.model.Task;
import de.ait.hw20250513_01.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

private final TaskService taskService;

    @PostMapping
public ResponseEntity<Task> addTask(@RequestBody TaskRequestDto taskRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(taskService.addTask(taskRequest));
}
@GetMapping
public ResponseEntity <List<Task>> getAllTasks() {
    return ResponseEntity.ok(taskService.getAllTasks());
}
}