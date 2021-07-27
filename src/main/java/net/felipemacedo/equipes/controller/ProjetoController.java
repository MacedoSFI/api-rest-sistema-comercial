package net.felipemacedo.equipes.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import net.felipemacedo.equipes.controller.dto.DetalhesDoProjetoDto;
import net.felipemacedo.equipes.controller.dto.ProjetoDto;
import net.felipemacedo.equipes.controller.form.AtualizacaoProjetoForm;
import net.felipemacedo.equipes.controller.form.ProjetoForm;
import net.felipemacedo.equipes.model.Projeto;
import net.felipemacedo.equipes.repository.ProjetoRepository;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@GetMapping
	public List<ProjetoDto> listar() {
		List<Projeto> projetos = projetoRepository.findAll();
		return ProjetoDto.converter(projetos);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProjetoDto> cadastrar(@RequestBody @Valid ProjetoForm form, UriComponentsBuilder uriBuilder) { //requestbody sign pegar os parametros do corpo da requisição. qd não tem pega da url
		Projeto projeto = form.converter();
		projetoRepository.save(projeto);//curso Spring Boot API REST: Construa uma API aula 02 Cadastrando tópicos
		URI uri = uriBuilder.path("/projetos/{id}").buildAndExpand(projeto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProjetoDto(projeto));
	}
	
	@GetMapping("/{id}")
	@Transactional
	public DetalhesDoProjetoDto detalhar(@PathVariable Long id) {
		Projeto projeto = projetoRepository.getOne(id);
		return new DetalhesDoProjetoDto(projeto);
	}
	
	@PutMapping("/{id}") //o AtualizacaoProjetoForm só esta permitindo atualizar descricao
	@Transactional
	public ResponseEntity<ProjetoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoProjetoForm form) {
		Projeto projeto = form.atualizar(id, projetoRepository);

		return ResponseEntity.ok(new ProjetoDto(projeto));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		projetoRepository.deleteById(id);

		return ResponseEntity.ok().build();
	}

}
