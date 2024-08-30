package com.kato.hexagonal.domain.ports.out;

import com.kato.hexagonal.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
