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
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(); // cross origin resource sharing (compartilhamento de recursos de origens cruzadas)

        http.csrf(AbstractHttpConfigurer::disable); // Habilita a segurança contra ataques csrf (Cross-site request forgery)

        http.formLogin(AbstractHttpConfigurer::disable); // Desabilita formulários de login html

        http.httpBasic(AbstractHttpConfigurer::disable);

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // Sem sessões

        http.authorizeHttpRequests((auth) -> auth

                // ======================================================================================================================= //
                //												     Endpoints de Login										               //
                // ======================================================================================================================= //
                .requestMatchers(HttpMethod.POST, "/login/*").permitAll()
                // ======================================================================================================================= //
                //												     Endpoints do Usuário										           //
                // ======================================================================================================================= //
                .requestMatchers(HttpMethod.POST, "/usuario/salvar-novo-usuario").hasAuthority(Role.ROLE_ADMIN.name())
                .requestMatchers(HttpMethod.PUT, "/usuario/atualizar-usuario").hasAuthority(Role.ROLE_ADMIN.name())
                .requestMatchers(HttpMethod.GET, "/usuario/buscar-usuario-por-nome").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/usuario/buscar-usuario-por-id").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.DELETE, "/usuario/deletar-usuario").hasAuthority(Role.ROLE_ADMIN.name())
                // ======================================================================================================================= //
                //												     Endpoints do Praticante										       //
                // ======================================================================================================================= //
                //  *********************************************** Ficha Cadastro Admissional *******************************************
                // # Completude Matricula
                .requestMatchers(HttpMethod.POST, "/praticante/completude-matricula/salvar-completude-matricula-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/completude-matricula/atualizar-completude-matricula-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/completude-matricula/buscar-completude-matricula-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Dados Pessoais
                .requestMatchers(HttpMethod.POST, "/praticante/dados-pessoais/salvar-dados-pessoais-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/dados-pessoais/atualizar-dados-pessoais-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/dados-pessoais/buscar-dados-pessoais-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/dados-pessoais/buscar-dados-pessoais-dos-praticantes").hasAuthority(Role.ROLE_USER.name())
                // # Educação Praticante
                .requestMatchers(HttpMethod.POST, "/praticante/educacao-praticante/salvar-educacao-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/educacao-praticante/atualizar-educacao-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/educacao-praticante/buscar-educacao-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Emergencia
                .requestMatchers(HttpMethod.POST, "/praticante/emergencia/salvar-emergencia-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/emergencia/atualizar-emergencia-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/emergencia/buscar-emergencia-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Outras Atividades Manha
                .requestMatchers(HttpMethod.POST, "/praticante/outras-atividades-manha/salvar-outras-atividades-manha-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/outras-atividades-manha/atualizar-outras-atividades-manha-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/outras-atividades-manha/buscar-outras-atividades-manha-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Outras Atividades Tarde
                .requestMatchers(HttpMethod.POST, "/praticante/outras-atividades-tarde/salvar-outras-atividades-tarde-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/outras-atividades-tarde/atualizar-outras-atividades-tarde-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/outras-atividades-tarde/buscar-outras-atividades-tarde-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Responsável do Praticante
                .requestMatchers(HttpMethod.POST, "/praticante/responsavel-pelo-praticante/salvar-responsavel-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/responsavel-pelo-praticante/atualizar-responsavel-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/responsavel-pelo-praticante/buscar-responsavel-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                //  *********************************************** Avaliação Fisioterapeutica *******************************************
                // # Avaliação Fisioterapeutica
                .requestMatchers(HttpMethod.POST, "/praticante/avaliacao-fisioterapeutica/salvar-avaliacao-fisioterapeutica-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/avaliacao-fisioterapeutica/atualizar-avaliacao-fisioterapeutica-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/avaliacao-fisioterapeutica/buscar-avaliacao-fisioterapeutica-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Coordenacao Motora
                .requestMatchers(HttpMethod.POST, "/praticante/coordenacao-motora/salvar-coordenacao-motora-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/coordenacao-motora/atualizar-coordenacao-motora-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/coordenacao-motora/buscar-coordenacao-motora-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Equilibrio Dinamico
                .requestMatchers(HttpMethod.POST, "/praticante/equilibrio-dinamico/salvar-equilibrio-dinamico-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/equilibrio-dinamico/atualizar-equilibrio-dinamico-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/equilibrio-dinamico/buscar-equilibrio-dinamico-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Equilibrio Estatico
                .requestMatchers(HttpMethod.POST, "/praticante/equilibrio-estatico/salvar-equilibrio-estatico-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/equilibrio-estatico/atualizar-equilibrio-estatico-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/equilibrio-estatico/buscar-equilibrio-estatico-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Forma de Comunicação
                .requestMatchers(HttpMethod.POST, "/praticante/forma-comunicacao/salvar-forma-comunicacao-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/forma-comunicacao/atualizar-forma-comunicacao-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/forma-comunicacao/buscar-forma-comunicacao-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Grupos Musculares
                .requestMatchers(HttpMethod.POST, "/praticante/grupos-musculares/salvar-grupos-musculares-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/grupos-musculares/atualizar-grupos-musculares-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/grupos-musculares/buscar-grupos-musculares-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Habilidades Motoras AVD
                .requestMatchers(HttpMethod.POST, "/praticante/habilidades-motoras-avd/salvar-habilidades-motoras-avd-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/habilidades-motoras-avd/atualizar-habilidades-motoras-avd-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/habilidades-motoras-avd/buscar-habilidades-motoras-avd-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Mobilidade Articular
                .requestMatchers(HttpMethod.POST, "/praticante/mobilidade-articular/salvar-mobilidade-articular-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/mobilidade-articular/atualizar-mobilidade-articular-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/mobilidade-articular/buscar-mobilidade-articular-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Quadro Atual
                .requestMatchers(HttpMethod.POST, "/praticante/quadro-atual/salvar-quadro-atual-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/quadro-atual/atualizar-quadro-atual-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/quadro-atual/buscar-quadro-atual-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Saude Geral dos Praticantes
                .requestMatchers(HttpMethod.POST, "/praticante/saude-geral-do-praticante/salvar-saude-geral-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/saude-geral-do-praticante/atualizar-saude-geral-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET, "/praticante/saude-geral-do-praticante/buscar-saude-geral-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                //  *********************************************** Avaliação Psicológica ************************************************
                // # Afetividade
                .requestMatchers(HttpMethod.POST, "/praticante/afetividade/salvar-afetividade-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/afetividade/atualizar-afetividade-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/afetividade/buscar-afetividade-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Avaliação Psicologica
                .requestMatchers(HttpMethod.POST, "/praticante/avaliacao-psicologica/salvar-avaliacao-psicologica-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/avaliacao-psicologica/atualizar-avaliacao-psicologica-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/avaliacao-psicologica/buscar-avaliacao-psicologica-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Comportamento
                .requestMatchers(HttpMethod.POST, "/praticante/comportamento/salvar-comportamento-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/comportamento/atualizar-comportamento-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/comportamento/buscar-comportamento-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Compreensao
                .requestMatchers(HttpMethod.POST, "/praticante/compreensao/salvar-compreensao-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/compreensao/atualizar-compreensao-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/compreensao/buscar-compreensao-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Cuidados Pessoais
                .requestMatchers(HttpMethod.POST, "/praticante/cuidados-pessoais/salvar-cuidados-pessoais-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/cuidados-pessoais/atualizar-cuidados-pessoais-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/cuidados-pessoais/buscar-cuidados-pessoais-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Habilidades Sociais
                .requestMatchers(HttpMethod.POST, "/praticante/habilidades-sociais/salvar-habilidades-sociais-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/habilidades-sociais/atualizar-habilidades-sociais-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/habilidades-sociais/buscar-habilidades-sociais-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Linguagem
                .requestMatchers(HttpMethod.POST, "/praticante/linguagem/salvar-linguagem-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/linguagem/atualizar-linguagem-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/linguagem/buscar-linguagem-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Relação Familiar Examinado
                .requestMatchers(HttpMethod.POST, "/praticante/relacao-familiar/salvar-relacao-familiar-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/relacao-familiar/atualizar-relacao-familiar-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/relacao-familiar/buscar-relacao-familiar-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Rotina
                .requestMatchers(HttpMethod.POST, "/praticante/rotina/salvar-rotina-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/rotina/atualizar-rotina-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/rotina/buscar-rotina-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Saude
                .requestMatchers(HttpMethod.POST, "/praticante/saude/salvar-saude-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/saude/atualizar-saude-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/saude/buscar-saude-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Saude Mental
                .requestMatchers(HttpMethod.POST, "/praticante/saude-mental/salvar-saude-mental-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/saude-mental/atualizar-saude-mental-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/saude-mental/buscar-saude-mental-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Sobre a Criança
                .requestMatchers(HttpMethod.POST, "/praticante/sobre-a-crianca/salvar-sobre-a-crianca-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/sobre-a-crianca/atualizar-sobre-a-crianca-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/sobre-a-crianca/buscar-sobre-a-crianca-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Socialização
                .requestMatchers(HttpMethod.POST, "/praticante/socializacao/salvar-socializacao-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/socializacao/atualizar-socializacao-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/socializacao/buscar-socializacao-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                // # Traços de Personalidade
                .requestMatchers(HttpMethod.POST, "/praticante/traços-personalidade/salvar-traços-personalidade-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/traços-personalidade/atualizar-traços-personalidade-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/traços-personalidade/buscar-traços-personalidade-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())
                //  *********************************************** Plano Terapeutico Singular *******************************************
                // # Plano Terapeutico Singular
                .requestMatchers(HttpMethod.POST, "/praticante/plano-terapeutico-singular/salvar-plano-terapeutico-singular-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.PUT, "/praticante/plano-terapeutico-singular/atualizar-plano-terapeutico-singular-do-praticante").hasAuthority(Role.ROLE_USER.name())
                .requestMatchers(HttpMethod.GET,"/praticante/plano-terapeutico-singular/buscar-plano-terapeutico-singular-do-praticante-por-id").hasAuthority(Role.ROLE_USER.name())

                .anyRequest().authenticated());
        http.addFilterBefore(this.filtroInterceptador, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
