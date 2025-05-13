package de.ait.hw20250513_01.repository;

import de.ait.hw20250513_01.model.Programmer;
import de.ait.hw20250513_01.model.Task;

import java.util.List;

public interface ProgrammerRepository {
    List<Programmer> findAll();
    Programmer findById(Long id);
    Programmer save(Programmer programmer);

    void addTaskToProgrammer(Long programmerId, Long taskId);
    void deleteTaskToProgrammer(Long programmerId, Long taskId);
    List<Task> findTasksByProgrammerId(Long id);

}