package de.ait.hw20250507_01.controller;


import de.ait.hw20250507_01.model.Task;
import de.ait.hw20250507_01.repository.TaskDB;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private final TaskDB taskDB;

    public TaskController(TaskDB taskDB) {
        this.taskDB = taskDB;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskDB.findAll();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskDB.findById(id).get();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskDB.save(task);
    }
@DeleteMapping("/{id}")
    public String deleteTaskById(@PathVariable Long id) {
        return taskDB.deleteById(id) ? "Task deleted" : "Task not found";
    }





}
