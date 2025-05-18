package de.ait.hw20250513_01.mappers;

import de.ait.hw20250513_01.dto.TaskRequestDto;
import de.ait.hw20250513_01.dto.TaskResponseDto;
import de.ait.hw20250513_01.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity(TaskRequestDto taskRequest);

    @Mapping(target = "programmerId", source = "programmer.id")
    TaskResponseDto toDto(Task task);
}