/*
 * Copyright (c) 2016, FIS™ and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package br.com.caparelli.bo.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.caparelli.bo.CargoBO;
import br.com.caparelli.dao.CargoDAO;
import br.com.caparelli.dto.CargoDTO;
import br.com.caparelli.model.Cargo;

/**
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	12 de jul de 2017
 *
 */
@Stateless
public class CargoBOImpl implements CargoBO {

	@EJB
	private CargoDAO dao;

	/* (non-Javadoc)
	 * @see br.com.caparelli.bo.CargoBO#list()
	 */
	@Override
	public List<CargoDTO> list() {
		List<Cargo> list = Optional.ofNullable(this.dao.list()).orElse(Collections.emptyList());
		return list.stream()
			.map(CargoDTO::new)
			.collect(Collectors.toList());
	}

	/* (non-Javadoc)
	 * @see br.com.caparelli.bo.CargoBO#findByDescricao(java.lang.String)
	 */
	@Override
	public CargoDTO findByDescricao(String descricao) {
		Cargo entity = this.dao.findByDescricao(descricao);
		if(entity != null) {
			return new CargoDTO(entity);
		}
		return null;
	}

}
