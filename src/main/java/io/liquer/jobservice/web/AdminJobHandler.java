package io.liquer.jobservice.web;

import io.liquer.jobservice.model.Job;
import io.liquer.jobservice.service.AdminJobService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class AdminJobHandler {

	private final AdminJobService jobService;
	public AdminJobHandler(AdminJobService jobService) {
		this.jobService = jobService;
	}

	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(jobService.findAll(), Job.class);
	}

	public Mono<ServerResponse> delete(ServerRequest request) {
		String id = request.pathVariable("id");
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(jobService.deleteById(id), Void.class);
	}
}
