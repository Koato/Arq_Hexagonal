package com.kato.hexagonal.infraestructure.adapters;

import com.kato.hexagonal.domain.models.AdditionalTaskInfo;
import com.kato.hexagonal.domain.ports.out.ExternalServicePort;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class ExternalServiceAdapter implements ExternalServicePort {

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    private final RestTemplate restTemplate;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + id;
        ResponseEntity<JsonPlaceHolderTodo> responseTodo = restTemplate.getForEntity(apiUrl, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = responseTodo.getBody();
        if(Objects.isNull(todo)){
            return null;
        }
        apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceHolderUser> responseUser = restTemplate.getForEntity(apiUrl, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser user = responseUser.getBody();
        if(Objects.isNull(user)){
            return null;
        }
        return new AdditionalTaskInfo(user.getId(), user.getName(), user.getEmail());
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class JsonPlaceHolderTodo {
        private Long id;
        private Long userId;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class JsonPlaceHolderUser {
        private Long id;
        private String name;
        private String email;
    }
}
