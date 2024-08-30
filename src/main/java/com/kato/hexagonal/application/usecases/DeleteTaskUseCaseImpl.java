package com.kato.hexagonal.application.usecases;

import com.kato.hexagonal.domain.ports.in.DeleteTaskUseCase;
import com.kato.hexagonal.domain.ports.out.TaskRepositoryPort;

public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    public DeleteTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Boolean deleteTask(Long id) {
        return taskRepositoryPort.deleteById(id);
    }
}
