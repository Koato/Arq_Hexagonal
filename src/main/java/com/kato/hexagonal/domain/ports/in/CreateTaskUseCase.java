package com.kato.hexagonal.domain.ports.in;

import com.kato.hexagonal.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
