package de.ait.hw20250513_01.controller;

import de.ait.hw20250513_01.dto.ProgrammerRequestDto;
import de.ait.hw20250513_01.model.Programmer;
import de.ait.hw20250513_01.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/programmers")
public class ProgrammerController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Programmer> addProgrammer(@RequestBody ProgrammerRequestDto programmerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.addProgrammer(programmerRequest));
    }

    @GetMapping
    public List<Programmer> getAllProgrammers() {
        return taskService.getAllProgrammers();
    }

    @PutMapping("/{programmerId}/tasks/{taskId}")
    public ResponseEntity<Void> addTaskToProgrammer(@PathVariable Long programmerId, @PathVariable Long taskId) {
        taskService.addTaskProgrammer(programmerId, taskId);
        return ResponseEntity.noContent().build();
    }

}