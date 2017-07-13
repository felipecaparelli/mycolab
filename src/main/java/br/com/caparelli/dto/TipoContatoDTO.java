package br.com.caparelli.dto;

import java.io.Serializable;

import br.com.caparelli.enumeration.TipoContato;
import lombok.Data;

/**
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	12 de jul de 2017
 *
 */
@Data
public class TipoContatoDTO implements Serializable {

	private static final long serialVersionUID = -4366951327787283327L;

	private String icone;
	private String tipo;

	public TipoContatoDTO(TipoContato tipoContato) {
		this.icone = tipoContato.getIcone();
		this.tipo = tipoContato.name();
	}

}
