package com.kato.hexagonal.domain.ports.in;

import com.kato.hexagonal.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task task);
}
