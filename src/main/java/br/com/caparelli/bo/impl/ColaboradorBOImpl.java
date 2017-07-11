package br.com.caparelli.bo.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.caparelli.bo.ColaboradorBO;
import br.com.caparelli.dao.ColaboradorDAO;
import br.com.caparelli.dto.ColaboradorDTO;
import br.com.caparelli.model.Colaborador;

@Stateless
public class ColaboradorBOImpl implements ColaboradorBO {

	@EJB
	private ColaboradorDAO dao;

	/* (non-Javadoc)
	 * @see br.com.caparelli.bo.ColaboradorBO#list()
	 */
	@Override
	public List<ColaboradorDTO> list() {
		List<Colaborador> list = Optional.ofNullable(this.dao.list()).orElse(Collections.emptyList());
		return list.stream()
			.map(ColaboradorDTO::new)
			.collect(Collectors.toList());
	}

}
