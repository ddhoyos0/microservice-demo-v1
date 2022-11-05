package org.example.application.queries.adapter.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends ReactiveCrudRepository<DirectoryModelView, String> {
}
