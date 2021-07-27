package net.felipemacedo.equipes.controller.form;

import org.hibernate.validator.constraints.Length;

import net.felipemacedo.equipes.model.Projeto;
import net.felipemacedo.equipes.repository.ProjetoRepository;

public class AtualizacaoProjetoForm {

	@Length(max=100000)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Projeto atualizar(Long id, ProjetoRepository projetoRepository) {
		Projeto projeto = projetoRepository.getOne(id);
		projeto.setDescricao(this.descricao);
		return projeto;
	}


}
