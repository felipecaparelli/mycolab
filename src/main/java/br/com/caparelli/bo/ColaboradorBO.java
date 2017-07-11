/*
 * Copyright (c) 2016, FIS™ and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package br.com.caparelli.bo;

import java.util.List;

import br.com.caparelli.dto.ColaboradorDTO;

/**
 * <b>Definicao</b>: Bo da entidade Colaborador
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	11 de jul de 2017
 *
 */
public interface ColaboradorBO {

	public List<ColaboradorDTO> list();

}
