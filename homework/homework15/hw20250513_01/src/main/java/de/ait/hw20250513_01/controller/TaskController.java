package de.ait.hw20250513_01.controller;

import de.ait.hw20250513_01.dto.TaskRequestDto;
import de.ait.hw20250513_01.model.Task;
import de.ait.hw20250513_01.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

private final TaskService taskService;

    @PostMapping
public void addTask(@RequestBody TaskRequestDto taskRequest) {
    taskService.addTask(taskRequest);
}
@GetMapping
public List<Task> getAllTasks() {
    return taskService.getAllTasks();
}



}