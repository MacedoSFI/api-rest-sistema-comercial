package net.felipemacedo.equipes.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import net.felipemacedo.equipes.model.Projeto;

public class ProjetoForm {
	
	@NotEmpty @Length(min=20, max=10000)
	private String titulo;
	
	@Length(max=100000)
	private String descricao;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Projeto converter() {// se aqui tivesse um atributo de classe, ex. converter(HabilidadeRepo habRepo){ ...
		return new Projeto(titulo, descricao); //^^^ Habilidade hab = habRepo.findById(idHab); ...
	}
}