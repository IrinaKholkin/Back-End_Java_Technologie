package de.ait.hw20250513_01.dto;

import de.ait.hw20250513_01.model.Priority;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskResponseDto {
    private Long id;
    private String description;
    private Priority priority;
    private Long programmerId;
}