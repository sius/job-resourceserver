package io.liquer.jobservice.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class AdminJobRouter {
	@Bean
	public RouterFunction<ServerResponse> routeAdminJob(AdminJobHandler handler) {
		return RouterFunctions
			.route(GET("/admin/jobs").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
			.andRoute(DELETE("/admin/jobs/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete);
	}
}
