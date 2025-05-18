package de.ait.hw20250513_01.repository;

import de.ait.hw20250513_01.model.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {
}