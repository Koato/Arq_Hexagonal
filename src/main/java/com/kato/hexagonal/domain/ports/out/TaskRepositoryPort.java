package com.kato.hexagonal.domain.ports.out;

import com.kato.hexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    List<Task> findAll();
    Task save(Task task);
    Optional<Task> findById(Long id);
    Optional<Task> update(Task task);
    Boolean deleteById(Long id);
}
