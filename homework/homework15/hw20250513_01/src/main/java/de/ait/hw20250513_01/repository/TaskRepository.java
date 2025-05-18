package de.ait.hw20250513_01.repository;

import de.ait.hw20250513_01.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}