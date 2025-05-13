package de.ait.tasks20250512_01.controller;

import de.ait.tasks20250512_01.model.Task;
import de.ait.tasks20250512_01.repository.TaskRepository;
//import de.ait.tasks20250512_01.repository.TaskRepositoryMapImpl;
//import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Scanner;

//@AllArgsConstructor
@RestController
public class TaskController {

    private final TaskRepository repository;

    private final Scanner scanner;

    public TaskController(@Qualifier("taskRepositoryMapImpl")TaskRepository repository, Scanner scanner) {
        this.repository = repository;
        this.scanner = scanner;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        System.out.println("input");
        String s = scanner.nextLine();
        System.out.println(s);
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