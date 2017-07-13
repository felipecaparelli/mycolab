package br.com.caparelli.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.com.caparelli.dao.CargoDAO;
import br.com.caparelli.model.Cargo;

/**
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	12 de jul de 2017
 *
 */
@Stateless
public class CargoDAOImpl extends DAOImpl<Cargo, Integer> implements CargoDAO {

	private static final long serialVersionUID = -4353039867345118202L;

	/* (non-Javadoc)
	 * @see br.com.caparelli.dao.CargoDAO#findByDescricao(java.lang.String)
	 */
	@Override
	public Cargo findByDescricao(String descricao) {
		try {

			return this.getEm()
					.createQuery("FROM Cargo c WHERE c.descricao = :descricao", Cargo.class)
					.setParameter("descricao", descricao)
					.setMaxResults(1)
					.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}

}
