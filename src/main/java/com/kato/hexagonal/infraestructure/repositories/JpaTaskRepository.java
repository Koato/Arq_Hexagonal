package com.kato.hexagonal.infraestructure.repositories;

import com.kato.hexagonal.infraestructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
