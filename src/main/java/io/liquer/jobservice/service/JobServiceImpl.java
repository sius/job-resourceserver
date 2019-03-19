package io.liquer.jobservice.service;

import io.liquer.jobservice.model.Job;
import io.liquer.jobservice.repository.ReactiveJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class JobServiceImpl implements JobService {

	private final ReactiveJobRepository jobRepository;

	@Autowired
	public JobServiceImpl(ReactiveJobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public Mono<Job> findById(String id) {
		return jobRepository.findById(id);
	}

	@Override
	public Mono<Job> save(Job job) {
		return jobRepository.save(job);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return jobRepository.deleteById(id);
	}
}
