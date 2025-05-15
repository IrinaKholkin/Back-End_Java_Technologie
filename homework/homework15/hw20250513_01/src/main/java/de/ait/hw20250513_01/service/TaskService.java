package de.ait.hw20250513_01.service;

import de.ait.hw20250513_01.dto.ProgrammerRequestDto;
import de.ait.hw20250513_01.dto.TaskRequestDto;
import de.ait.hw20250513_01.model.Programmer;
import de.ait.hw20250513_01.model.Task;

import java.util.List;

public interface TaskService {
    Task addTask(TaskRequestDto taskRequest);
    Programmer addProgrammer(ProgrammerRequestDto programmerRequest);
    List<Task> getAllTasks();
    List<Programmer> getAllProgrammers();
    void addTaskProgrammer(Long programmerId, Long taskId);
}
