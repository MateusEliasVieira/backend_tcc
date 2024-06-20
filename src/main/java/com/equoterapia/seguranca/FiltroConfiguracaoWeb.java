package com.equoterapia.seguranca;

import com.equoterapia.dominio.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class FiltroConfiguracaoWeb {

	@Autowired
	private FiltroInterceptador filtroInterceptador;

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {

		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOrigin("*"); // Permite todas as origens, você pode personalizar isso
		// Methods http authorized
		configuration.addAllowedMethod("GET");
		configuration.addAllowedMethod("POST");
		configuration.addAllowedMethod("PUT");
		configuration.addAllowedMethod("DELETE");
		configuration.addAllowedMethod("OPTIONS");
		// Headers http authorized
		configuration.addAllowedHeader("Authorization");
		configuration.addAllowedHeader("Content-Type");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		return source;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.cors(); // cross origin resource sharing (compartilhamento de recursos de origens cruzadas)

		http.csrf(AbstractHttpConfigurer::disable); // Habilita a segurança contra ataques csrf (Cross-site request forgery)

		http.formLogin(AbstractHttpConfigurer::disable); // Desabilita formulários de login html

		http.httpBasic(AbstractHttpConfigurer::disable);

		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // Sem sessões

		http.authorizeHttpRequests((auth) -> auth
				// Login Controller
				.requestMatchers(HttpMethod.POST, "/login/*").permitAll()
				// ====== Usuário =======
				.requestMatchers(HttpMethod.POST, "/usuario/salvar-novo-usuario").hasAuthority(Role.ROLE_ADMIN.name())
                .requestMatchers(HttpMethod.PUT, "/usuario/atualizar-usuario").hasAuthority(Role.ROLE_ADMIN.name())
				.requestMatchers(HttpMethod.GET, "/usuario/buscar-usuario-por-nome").hasAuthority(Role.ROLE_USER.name())
				.requestMatchers(HttpMethod.GET, "/usuario/buscar-usuario-por-id").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.DELETE, "/usuario/deletar-usuario").hasAuthority(Role.ROLE_ADMIN.name())
				// ====== Paciente =======
				// Dados Pessoais
				.requestMatchers(HttpMethod.POST, "/praticante/dados-pessoais/salvar-dados-pessoais-do-praticante").hasAuthority(Role.ROLE_USER.name())
				.requestMatchers(HttpMethod.PUT, "/praticante/dados-pessoais/atualizar-dados-pessoais-do-praticante").hasAuthority(Role.ROLE_USER.name())
				.requestMatchers(HttpMethod.GET,"/praticante/dados-pessoais/buscar-dados-pessoais-do-praticante-por-id/*").hasAuthority(Role.ROLE_USER.name())
				.requestMatchers(HttpMethod.GET,"/praticante/dados-pessoais/buscar-dados-pessoais-dos-praticantes").hasAuthority(Role.ROLE_USER.name())
				// Completude Matricula
				.requestMatchers(HttpMethod.POST, "/praticante/completude-matricula/salvar-completude-matricula-do-praticante").hasAuthority(Role.ROLE_USER.name())
				.requestMatchers(HttpMethod.PUT, "/praticante/completude-matricula/atualizar-completude-matricula-do-praticante").hasAuthority(Role.ROLE_USER.name())
				.requestMatchers(HttpMethod.GET,"/praticante/completude-matricula/buscar-completude-matricula-do-praticante-por-id/*").hasAuthority(Role.ROLE_USER.name())
				// Educação Paciente
				.requestMatchers(HttpMethod.POST, "/praticante/educacao-praticante/salvar-educacao-do-praticante").hasAuthority(Role.ROLE_USER.name())
				.requestMatchers(HttpMethod.PUT, "/praticante/educacao-praticante/atualizar-educacao-do-praticante").hasAuthority(Role.ROLE_USER.name())
				.requestMatchers(HttpMethod.GET,"/praticante/educacao-praticante/buscar-educacao-do-praticante-por-id/*").hasAuthority(Role.ROLE_USER.name())
				// Emergencia
				.requestMatchers(HttpMethod.POST, "/praticante/emergencia/salvar-emergencia-do-praticante").hasAuthority(Role.ROLE_USER.name())
				.requestMatchers(HttpMethod.PUT, "/praticante/emergencia/atualizar-emergencia-do-praticante").hasAuthority(Role.ROLE_USER.name())
				.requestMatchers(HttpMethod.GET,"/praticante/emergencia/buscar-emergencia-do-praticante-por-id/*").hasAuthority(Role.ROLE_USER.name())
				.anyRequest().authenticated());
		http.addFilterBefore(this.filtroInterceptador, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}
