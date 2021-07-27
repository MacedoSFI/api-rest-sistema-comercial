package net.felipemacedo.equipes.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.felipemacedo.equipes.model.Habilidade;
import net.felipemacedo.equipes.model.Projeto;

public class DetalhesDoProjetoDto {

	private Long id;
	private String titulo;
	private String descricao;
	private List<HabilidadeDto> habilidades;
	
	public DetalhesDoProjetoDto(Projeto Projeto) {
		this.id = Projeto.getId();
		this.titulo = Projeto.getTitulo();
		this.descricao = Projeto.getDescricao();
		this.habilidades = new ArrayList<>();
		this.habilidades.addAll(Projeto.getHabilidades().stream().map(HabilidadeDto::new).collect(Collectors.toList()));
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<HabilidadeDto> getHabilidades() {
		return habilidades;
	}
	
}
