package de.ait.hw20250513_01.mappers;

import de.ait.hw20250513_01.dto.ProgrammerRequestDto;
import de.ait.hw20250513_01.dto.ProgrammerResponseDto;
import de.ait.hw20250513_01.model.Programmer;
import de.ait.hw20250513_01.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProgrammerMapper {
    Programmer toEntity(ProgrammerRequestDto programmerRequest);

    @Mapping(target = "taskIds", expression = "java(mapTasksToIds(programmer.getTasks()))")
    ProgrammerResponseDto toDto(Programmer programmer);

    default List<Long> mapTasksToIds(Set<Task> tasks) {
        if (tasks == null) {
            return null;
        }
        return tasks.stream().map(Task::getId).collect(Collectors.toList());
    }
}