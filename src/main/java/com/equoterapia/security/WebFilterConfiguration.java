package com.equoterapia.security;

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
public class WebFilterConfiguration {

	@Autowired
	private InterceptorFilter interceptorFilter;

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
				.requestMatchers(HttpMethod.POST, "/usuario/salvar-novo-usuario").permitAll()
                .requestMatchers(HttpMethod.PUT, "/usuario/atualizar-usuario").permitAll()
				.requestMatchers(HttpMethod.GET, "/usuario/buscar-usuario-por-nome").permitAll()
				.requestMatchers(HttpMethod.GET, "/usuario/buscar-usuario-por-id").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/usuario/deletar-usuario").permitAll()
				// ====== Paciente =======
				// Dados Pessoais
				.requestMatchers(HttpMethod.POST, "/paciente/salvar-novo-paciente").permitAll()
				.requestMatchers(HttpMethod.POST, "/paciente/dados-pessoais/*").permitAll()
				.requestMatchers(HttpMethod.PUT, "/paciente/dados-pessoais/*").permitAll()
				.requestMatchers(HttpMethod.GET,"/paciente/dados-pessoais/buscar-dados-pessoais-por-id/*").permitAll()
				.requestMatchers(HttpMethod.GET,"/paciente/dados-pessoais/buscar-dados-pessoais-dos-pacientes").permitAll()
				// Completude Matricula
				.requestMatchers(HttpMethod.POST, "/paciente/completude-matricula/salvar-completude-matricula").permitAll()
				.requestMatchers(HttpMethod.PUT, "/paciente/completude-matricula/atualizar-completude-matricula").permitAll()
				.requestMatchers(HttpMethod.GET,"/paciente/completude-matricula/buscar-completude-matricula-por-id/*").permitAll()
				// Educação Paciente
				.requestMatchers(HttpMethod.POST, "/paciente/educacao-paciente/salvar-educacao-paciente").permitAll()
				.requestMatchers(HttpMethod.PUT, "/paciente/educacao-paciente/atualizar-educacao-paciente").permitAll()
				.requestMatchers(HttpMethod.GET,"/paciente/educacao-paciente/buscar-educacao-paciente-por-id/*").permitAll()
				// Emergencia
				.requestMatchers(HttpMethod.POST, "/paciente/emergencia/salvar-emergencia").permitAll()
				.requestMatchers(HttpMethod.PUT, "/paciente/emergencia/atualizar-emergencia").permitAll()
				.requestMatchers(HttpMethod.GET,"/paciente/emergencia/buscar-emergencia-por-id/*").permitAll()
				.anyRequest().authenticated());

		http.addFilterBefore(this.interceptorFilter, UsernamePasswordAuthenticationFilter.class);

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
