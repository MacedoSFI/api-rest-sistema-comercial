package net.felipemacedo.equipes.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import net.felipemacedo.equipes.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AutenticacaoService autenticacaoService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	//configura autenticação 
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
			.antMatchers("/index").permitAll()
			.antMatchers("/ok").permitAll()
			.antMatchers("/auth").permitAll()
			.anyRequest().authenticated()
			.and()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)// quando autenticar não é para criar sessão
			.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, userRepository), UsernamePasswordAuthenticationFilter.class);
		//essa classe de filtro não pode ter @.^^^^ então é uma forma de informar ao Spring colocando ele aqui			
		
	}
	
	//configura autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth
		.userDetailsService(autenticacaoService)//tem a lógica de autent.
		.passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
	//configurações de serviços staticos (js, css, img)
	@Override
	public void configure(WebSecurity web) throws Exception {

	}
	
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println(new BCryptPasswordEncoder().encode("1234")); }
	 */
	
	
}
