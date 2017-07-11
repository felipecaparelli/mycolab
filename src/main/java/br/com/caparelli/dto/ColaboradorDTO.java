package br.com.caparelli.dto;

import java.io.Serializable;

import br.com.caparelli.model.Colaborador;
import lombok.Getter;

/**
 * <b>Definicao</b>: DTO do colaborador.
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	11 de jul de 2017
 *
 */
@Getter
public class ColaboradorDTO implements Serializable {

	private static final long serialVersionUID = -609154102223809333L;

	private String nome;
	private String cargo;
	private String nomeSetor;
	private String iconeSetor;

	public ColaboradorDTO(Colaborador entity) {

		if(entity != null) {

			this.nome = entity.getNome();

			if(entity.getCargo() != null) {
				this.cargo = entity.getCargo().getDescricao();
			}

			if(entity.getSetor() != null) {
				this.nomeSetor = entity.getSetor().getNome();
				this.iconeSetor = entity.getSetor().getIcone();

			}
		}
	}

}
