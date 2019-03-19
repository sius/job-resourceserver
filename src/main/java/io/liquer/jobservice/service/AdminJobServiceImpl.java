package io.liquer.jobservice.service;

import io.liquer.jobservice.model.Job;
import io.liquer.jobservice.repository.ReactiveJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AdminJobServiceImpl implements AdminJobService {

	private final ReactiveJobRepository jobRepository;

	@Autowired
	public AdminJobServiceImpl(ReactiveJobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public Flux<Job> findAll() {
		return jobRepository.findAll();
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return jobRepository.deleteById(id);
	}
}
