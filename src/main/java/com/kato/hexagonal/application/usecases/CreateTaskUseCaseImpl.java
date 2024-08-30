package com.kato.hexagonal.application.usecases;

import com.kato.hexagonal.domain.models.Task;
import com.kato.hexagonal.domain.ports.in.CreateTaskUseCase;
import com.kato.hexagonal.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
