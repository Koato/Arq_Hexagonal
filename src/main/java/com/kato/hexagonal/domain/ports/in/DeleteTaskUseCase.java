package com.kato.hexagonal.domain.ports.in;

public interface DeleteTaskUseCase {
    Boolean deleteTask(Long id);
}
