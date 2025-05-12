package de.ait.tasks20250512_01.repository;

import de.ait.tasks20250512_01.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
    Task findById(Long id);
    Task delete(Long id);
    Task save(Task task);


}