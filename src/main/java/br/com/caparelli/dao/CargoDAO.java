package br.com.caparelli.dao;

import br.com.caparelli.model.Cargo;

/**
 * <b>Definicao</b>: DAO da entidade Cargo
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	12 de jul de 2017
 *
 */
public interface CargoDAO extends DAO<Cargo, Integer> {

	public Cargo findByDescricao(String descricao);

}
