package io.liquer.jobservice.repository;

import io.liquer.jobservice.model.Job;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveJobRepository extends ReactiveMongoRepository<Job, String> {

}
