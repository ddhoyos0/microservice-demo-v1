package org.example.business;

import org.example.business.gateway.ValidOwnerOfAccountService;
import org.example.domain.Account;
import org.example.domain.Directory;
import org.example.domain.command.CreateDirectoryCommand;
import org.example.generic.domain.DomainEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class CreateDirectoryUseCase implements Function<Mono<CreateDirectoryCommand>, Flux<DomainEvent>> {
    private final ValidOwnerOfAccountService service;

    public CreateDirectoryUseCase(ValidOwnerOfAccountService service) {
        this.service = service;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<CreateDirectoryCommand> commandMono) {
        return commandMono.flatMapMany(command -> service.valid(command.getName()).flatMapIterable(isValid -> {
            if(!isValid.equals(Boolean.TRUE)){
                throw new IllegalArgumentException("Business Exception");
            }
            var account = new Directory(command.getId(), command.getName(), command.getEmail(), command.getUserId());
            return account.getUncommittedChanges();
        }));
    }
}
