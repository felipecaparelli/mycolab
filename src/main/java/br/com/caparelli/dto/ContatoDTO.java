package br.com.caparelli.dto;

import br.com.caparelli.model.ContatoColaborador;
import lombok.Data;

/**
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli (lc45824)
 * @date	12 de jul de 2017
 *
 */
@Data
public class ContatoDTO {

	private String icone;
	private String contato;

	public ContatoDTO(ContatoColaborador entity) {
		if(entity != null) {
			if(entity.getTipo() != null){
				this.icone = entity.getTipo().getIcone();
			}
			this.contato = entity.getContato();
		}
	}

}
