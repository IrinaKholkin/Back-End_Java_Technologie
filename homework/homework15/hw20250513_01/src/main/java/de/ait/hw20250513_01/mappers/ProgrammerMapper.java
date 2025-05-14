package de.ait.hw20250513_01.mappers;

import de.ait.hw20250513_01.dto.ProgrammerRequestDto;
import de.ait.hw20250513_01.dto.ProgrammerResponseDto;
import de.ait.hw20250513_01.model.Programmer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgrammerMapper {
    Programmer toEntity(ProgrammerRequestDto programmerRequest);
    Programmer toDto(Programmer entity);
}
