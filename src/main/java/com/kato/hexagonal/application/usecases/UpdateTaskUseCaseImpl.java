package com.kato.hexagonal.application.usecases;

import com.kato.hexagonal.domain.models.Task;
import com.kato.hexagonal.domain.ports.in.UpdateTaskUseCase;
import com.kato.hexagonal.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return taskRepositoryPort.update(task);
    }
}
