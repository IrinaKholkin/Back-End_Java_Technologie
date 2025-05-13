package de.ait.tasks20250512_01.repository;

import de.ait.tasks20250512_01.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryListImpl implements TaskRepository{
    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public Task findById(Long id) {
        return null;
    }

    @Override
    public Task delete(Long id) {
        return null;
    }

    @Override
    public Task save(Task task) {
        return null;
    }
}