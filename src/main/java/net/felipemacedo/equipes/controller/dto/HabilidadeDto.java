package net.felipemacedo.equipes.controller.dto;

import net.felipemacedo.equipes.model.Habilidade;

public class HabilidadeDto {

	private Long id;
	
	private String nome;
	
	public HabilidadeDto(Habilidade habilidade) {
		this.id = habilidade.getId();
		this.nome = habilidade.getNome();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	
}
