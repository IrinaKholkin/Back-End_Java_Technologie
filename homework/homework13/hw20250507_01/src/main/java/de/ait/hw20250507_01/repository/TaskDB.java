package de.ait.hw20250507_01.repository;

import de.ait.hw20250507_01.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskDB {
    private final List<Task> tasks = new ArrayList<>();
    private long currentId = 1;

    public TaskDB() {
        tasks.add(new Task(currentId++, "Task #" + currentId, "Task Description"));
        tasks.add(new Task(currentId++, "Task #" + currentId, "Task Description"));
        tasks.add(new Task(currentId++, "Task #" + currentId, "Task Description"));
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Optional<Task> findById(long id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst();
    }
     public Task save(Task task) {
        task.setId(currentId++);
        tasks.add(task);
        return task;
     }

     public boolean deleteById(long id) {
        return tasks.removeIf(task -> task.getId() == id);
     }
}
