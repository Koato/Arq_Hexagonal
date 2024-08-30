package com.kato.hexagonal.domain.ports.in;

import com.kato.hexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetriveTaskUseCase {
    Optional<Task> getTask(Long id);
    List<Task> getAllTasks();
}
