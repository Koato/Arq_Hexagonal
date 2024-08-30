package com.kato.hexagonal.domain.models;

import lombok.*;

@Setter
@AllArgsConstructor
@Builder
public class AdditionalTaskInfo {

    private final Long userId;
    private final String userName;
    private final String userEmail;
}
