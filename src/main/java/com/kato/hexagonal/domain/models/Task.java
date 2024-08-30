package com.kato.hexagonal.domain.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Boolean completed;
}
