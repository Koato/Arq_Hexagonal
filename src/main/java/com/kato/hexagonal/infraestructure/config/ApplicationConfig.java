package com.kato.hexagonal.infraestructure.config;

import com.kato.hexagonal.application.services.TaskService;
import com.kato.hexagonal.application.usecases.*;
import com.kato.hexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.kato.hexagonal.domain.ports.out.ExternalServicePort;
import com.kato.hexagonal.domain.ports.out.TaskRepositoryPort;
import com.kato.hexagonal.infraestructure.adapters.ExternalServiceAdapter;
import com.kato.hexagonal.infraestructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                new RetriveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase);
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }
}
