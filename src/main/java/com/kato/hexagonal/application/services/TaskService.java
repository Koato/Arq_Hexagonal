package com.kato.hexagonal.application.services;

import com.kato.hexagonal.domain.models.AdditionalTaskInfo;
import com.kato.hexagonal.domain.models.Task;
import com.kato.hexagonal.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class TaskService implements CreateTaskUseCase, DeleteTaskUseCase, RetriveTaskUseCase, UpdateTaskUseCase, GetAdditionalTaskInfoUseCase {

    public TaskService(CreateTaskUseCase createTaskUseCase, DeleteTaskUseCase deleteTaskUseCase, RetriveTaskUseCase retriveTaskUseCase, UpdateTaskUseCase updateTaskUseCase, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.retriveTaskUseCase = retriveTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    private final CreateTaskUseCase createTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final RetriveTaskUseCase retriveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;


    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public Boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return retriveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retriveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return updateTaskUseCase.updateTask(id, task);
    }
}
