package io.liquer.helper;

import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import reactor.core.publisher.Mono;

import java.util.Set;

public class ReactiveHelper {

	private ReactiveHelper() {}

	public static ReactiveAuthorizationManager<AuthorizationContext> hasAuthorities(String...authorities ) {

		final Set<String> authoritiesSet = Set.of(authorities);

		return (Mono<Authentication> mono, AuthorizationContext context) ->
				mono
						.map(auth -> auth.getAuthorities().stream()
								.filter(e -> authoritiesSet.contains(e.getAuthority()))
								.count() > 0)
						.map(AuthorizationDecision::new);
	}
}
