package com.kato.hexagonal.infraestructure.entities;

import com.kato.hexagonal.domain.models.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private Boolean completed;

    public static TaskEntity fromDomainModel(Task task) {
        return new TaskEntity(task.getId(), task.getTitle(), task.getDescription(), task.getCreatedAt(), task.getCompleted());
    }

    public Task toDomainModel(){
        return new Task(id, title, description, createdAt, completed);
    }
}
