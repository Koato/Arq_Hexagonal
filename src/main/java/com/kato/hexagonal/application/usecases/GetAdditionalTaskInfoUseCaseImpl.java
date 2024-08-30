package com.kato.hexagonal.application.usecases;

import com.kato.hexagonal.domain.models.AdditionalTaskInfo;
import com.kato.hexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.kato.hexagonal.domain.ports.out.ExternalServicePort;
import com.kato.hexagonal.domain.ports.out.TaskRepositoryPort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    private final ExternalServicePort externalServicePort;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
