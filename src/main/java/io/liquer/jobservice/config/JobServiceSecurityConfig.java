package io.liquer.jobservice.config;

import io.liquer.helper.ReactiveHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import static io.liquer.helper.ReactiveHelper.hasAuthorities;

@EnableWebFluxSecurity
public class JobServiceSecurityConfig  {



	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		http
				.csrf().disable()
				.authorizeExchange()
				.pathMatchers("/jobs").hasAuthority("SCOPE_message:read")
				.pathMatchers("/jobs/*").hasAuthority("SCOPE_message:read")
				.pathMatchers("/admin/jobs").access(hasAuthorities("ROLE_USER", "SCOPE_message:read"))
				.pathMatchers("/hello").access(hasAuthorities("ROLE_USER", "SCOPE_message:read"))
				.anyExchange().authenticated()
				.and()
				.httpBasic()
				.and()
				.oauth2ResourceServer()
				.jwt();

		return http.build();
	}

//	@Bean
//	public MapReactiveUserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("user")
//				.roles("USER")
//				.build();
//		return new MapReactiveUserDetailsService(user);
//	}

//	@Bean
//	SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//		http
//				// ...
//				.headers()
//				.hsts().disable()
//				.frameOptions().mode(Mode.SAMEORIGIN);
//		return http.build();
//	}
}
