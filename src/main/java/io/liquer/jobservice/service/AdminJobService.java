package io.liquer.jobservice.service;

import io.liquer.jobservice.model.Job;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AdminJobService {
	Flux<Job> findAll();
	Mono<Void> deleteById(String id);
}
