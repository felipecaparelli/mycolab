package br.com.caparelli.bo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.caparelli.bo.TipoContatoBO;
import br.com.caparelli.dto.TipoContatoDTO;
import br.com.caparelli.enumeration.TipoContato;

/**
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	12 de jul de 2017
 *
 */
@Stateless
public class TipoContatoBOImpl implements TipoContatoBO {

	/* (non-Javadoc)
	 * @see br.com.caparelli.bo.TipoContatoBO#list()
	 */
	@Override
	public List<TipoContatoDTO> list() {

		TipoContato[] tipos = TipoContato.values();
		List<TipoContatoDTO> list = new ArrayList<>(tipos.length);
		//old school :)
		for(int index = 0; index < tipos.length; index++) {
			list.add(new TipoContatoDTO(tipos[index]));
		}

		return list;
	}

}
