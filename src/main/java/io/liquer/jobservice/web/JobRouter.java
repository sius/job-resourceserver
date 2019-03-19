package io.liquer.jobservice.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class JobRouter {
	@Bean
	public RouterFunction<ServerResponse> routeJob(JobHandler handler) {
		return RouterFunctions
			.route(GET("/jobs/{id}").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findById)
			.andRoute(POST("/jobs").and(accept(MediaType.APPLICATION_JSON)), handler::save)
			.andRoute(DELETE("/jobs/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete);
	}
}
