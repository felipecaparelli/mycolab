package br.com.caparelli.dao.impl;

import javax.ejb.Stateless;

import br.com.caparelli.dao.ColaboradorDAO;
import br.com.caparelli.model.Colaborador;

/**
 * <b>Definicao</b>: DAO da entidade Colaborador
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	11 de jul de 2017
 *
 */
@Stateless
public class ColaboradorDAOImpl extends DAOImpl<Colaborador, Integer> implements ColaboradorDAO {

	private static final long serialVersionUID = -2904821110575520208L;

}
