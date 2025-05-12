package de.ait.tasks20250512_01.controller;

import de.ait.tasks20250512_01.model.Task;
import de.ait.tasks20250512_01.repository.TaskRepository;
import de.ait.tasks20250512_01.repository.TaskRepositoryMapImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class TaskController {
    private final TaskRepository repository;

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return repository.findAll();
    }


    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable("id") Long taskId){
        return repository.findById(taskId);
    }

    @PostMapping("/tasks")
    public Task createNewTask(@RequestBody Task task){
        System.out.println(task);
        return repository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public  Task deleteTaskById(@PathVariable("id") Long id){
        return repository.delete(id);
    }




}