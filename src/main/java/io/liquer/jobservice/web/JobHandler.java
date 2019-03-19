package io.liquer.jobservice.web;

import io.liquer.jobservice.model.Job;
import io.liquer.jobservice.service.JobService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.server.ServerResponse.created;


@Component
public class JobHandler {

	private final JobService jobService;
	public JobHandler(JobService jobService) {
		this.jobService = jobService;
	}
	public Mono<ServerResponse> findById(ServerRequest request) {
		String id = request.pathVariable("id");
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(jobService.findById(id), Job.class);
	}
	public Mono<ServerResponse> save(ServerRequest request) {
		final Mono<Job> job = request.bodyToMono(Job.class);
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(job.flatMap(jobService::save), Job.class));
	}
	public Mono<ServerResponse> delete(ServerRequest request) {
		String id = request.pathVariable("id");
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(jobService.deleteById(id), Void.class);
	}
}

