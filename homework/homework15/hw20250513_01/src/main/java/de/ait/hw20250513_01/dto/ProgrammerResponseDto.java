package de.ait.hw20250513_01.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class ProgrammerResponseDto {
    private Long id;
    private String name;
    private List<Long> taskIds;

}