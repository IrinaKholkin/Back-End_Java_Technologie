package de.ait.hw20250513_01.service;

import de.ait.hw20250513_01.dto.ProgrammerRequestDto;
import de.ait.hw20250513_01.dto.ProgrammerResponseDto;
import de.ait.hw20250513_01.dto.TaskRequestDto;
import de.ait.hw20250513_01.dto.TaskResponseDto;
import de.ait.hw20250513_01.mappers.ProgrammerMapper;
import de.ait.hw20250513_01.mappers.TaskMapper;
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
    private final TaskMapper taskMapper;
    private final ProgrammerMapper programmerMapper;

    @Override
    public Task addTask(TaskRequestDto taskRequest) {
        Task task = taskMapper.toEntity(taskRequest);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDto(savedTask);
    }
    @Override
    public Programmer addProgrammer(ProgrammerRequestDto programmerRequest) {
        Programmer programmer = programmerMapper.toEntity(programmerRequest);
        return programmerMapper.toDto(programmerRepository.save(programmer));
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
