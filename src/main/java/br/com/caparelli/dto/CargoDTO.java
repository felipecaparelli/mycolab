package br.com.caparelli.dto;

import java.io.Serializable;

import br.com.caparelli.model.Cargo;
import lombok.Data;

/**
 * <b>Definicao</b>: DTO de Cargo.
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	12 de jul de 2017
 *
 */
@Data
public class CargoDTO implements Serializable {

	private static final long serialVersionUID = 6374121530489139018L;

	private String descricao;

	public CargoDTO(Cargo entity) {
		if(entity != null) {
			this.descricao = entity.getDescricao();
		}
	}

}
