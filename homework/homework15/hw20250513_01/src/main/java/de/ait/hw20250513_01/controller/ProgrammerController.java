package de.ait.hw20250513_01.controller;

import de.ait.hw20250513_01.dto.ProgrammerRequestDto;
import de.ait.hw20250513_01.model.Programmer;
import de.ait.hw20250513_01.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/programmers")
public class ProgrammerController {

    private final TaskService taskService;

    @PostMapping
    public void addProgrammer(@RequestBody ProgrammerRequestDto programmerRequest) {
        taskService.addProgrammer(programmerRequest);
    }

    @GetMapping
    public List<Programmer> getAllProgrammers() {
        return taskService.getAllProgrammers();
    }

    @PutMapping("/{programmerId}/tasks/{taskId}")
    public void addTaskToProgrammer(@PathVariable Long programmerId, @PathVariable Long taskId) {
        taskService.addTaskProgrammer(programmerId, taskId);
    }

}