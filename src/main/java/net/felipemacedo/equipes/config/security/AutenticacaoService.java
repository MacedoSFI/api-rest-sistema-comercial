package net.felipemacedo.equipes.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.felipemacedo.equipes.model.User;
import net.felipemacedo.equipes.repository.UserRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<User> user = repository.findByEmail(email); //trocar isso, ou username ou email. Tá confuso
		
		if (user.isPresent()) {
			return user.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidos!");
	}

}
