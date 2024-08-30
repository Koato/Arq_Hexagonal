package com.kato.hexagonal.application.usecases;

import com.kato.hexagonal.domain.models.Task;
import com.kato.hexagonal.domain.ports.in.RetriveTaskUseCase;
import com.kato.hexagonal.domain.ports.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetriveTaskUseCaseImpl implements RetriveTaskUseCase {

    public RetriveTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }
}
