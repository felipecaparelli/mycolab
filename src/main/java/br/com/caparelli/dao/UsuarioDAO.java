/*
 * Copyright (c) 2016, FIS™ and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package br.com.caparelli.dao;

import br.com.caparelli.exception.AcessoNegadoException;
import br.com.caparelli.model.Usuario;

/**
 * <b>Definicao</b>: DAO para a entidade Usuario
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	10 de jul de 2017
 *
 */
public interface UsuarioDAO {

	/**
	 * Realiza a busca do usuário a partir de seu username e password.
	 * Dispara uma exceção de acesso negado se não encontrar.
	 *
	 * @param username
	 * @param password
	 *
	 * @return Usuario
	 */
	public Usuario login(String username, String password) throws AcessoNegadoException;

}
