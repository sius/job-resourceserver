package io.liquer.jobservice.service;

import io.liquer.jobservice.model.Job;
import reactor.core.publisher.Mono;

public interface JobService {

	Mono<Job> findById(String id);
	Mono<Job> save(Job job);
	Mono<Void> deleteById(String id);

}
