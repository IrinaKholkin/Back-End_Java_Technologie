package de.ait.hw20250513_01.service;

import de.ait.hw20250513_01.dto.ProgrammerRequestDto;
import de.ait.hw20250513_01.dto.TaskRequestDto;
import de.ait.hw20250513_01.model.Programmer;
import de.ait.hw20250513_01.model.Task;
import de.ait.hw20250513_01.repository.ProgrammerRepository;
import de.ait.hw20250513_01.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ProgrammerRepository programmerRepository;

    @Override
    public Task addTask(TaskRequestDto taskRequest) {
        Task task = new Task();

        task.setDescription(taskRequest.getDescription());
        task.setPriority(taskRequest.getPriority());
        return taskRepository.save(task);
    }

    @Override
    public Programmer addProgrammer(ProgrammerRequestDto programmerRequest) {
        Programmer programmer = new Programmer();
        programmer.setName(programmerRequest.getName());
        return programmerRepository.save(programmer);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Programmer> getAllProgrammers() {
        return programmerRepository.findAll();
    }

    @Override
    public void addTaskProgrammer(Long programmerId, Long taskId) {
        programmerRepository.addTaskToProgrammer(programmerId, taskId);
    }
}
