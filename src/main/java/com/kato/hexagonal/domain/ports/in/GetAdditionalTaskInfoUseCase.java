package com.kato.hexagonal.domain.ports.in;

import com.kato.hexagonal.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
