package org.example.application.queries.handle;


import org.example.application.queries.adapter.repo.AccountRepository;
import org.example.application.queries.adapter.repo.DirectoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class QueryHandle {

    private final DirectoryRepository directoryRepository;
    private final AccountRepository accountRepository;
    public QueryHandle(DirectoryRepository directoryRepository, AccountRepository accountRepository) {
        this.directoryRepository = directoryRepository;
        this.accountRepository = accountRepository;
    }
    @Bean
    public RouterFunction<ServerResponse> getDirectoryById() {
        return route(
                GET("/directory/{id}"),
                request -> directoryRepository.findById(request.pathVariable("id"))
                        .flatMap(directory -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(directory)));
    }
    @Bean
    public RouterFunction<ServerResponse> getAccount() {
        return route(
                GET("/account/{id}"),
                request -> accountRepository.findById(request.pathVariable("id"))
                        .flatMap(account -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(account))
        );
    }
}
