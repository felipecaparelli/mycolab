package br.com.caparelli.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.com.caparelli.dao.UsuarioDAO;
import br.com.caparelli.exception.AcessoNegadoException;
import br.com.caparelli.model.Usuario;

@Stateless
public class UsuarioDAOImpl extends DAOImpl<Usuario, Long> implements UsuarioDAO {

	private static final long serialVersionUID = 7503481134251639583L;

	@Override
	public Usuario login(String username, String password) throws AcessoNegadoException {

		try {

			return this.getEm()
					.createQuery("FROM Usuario u WHERE u.username = :username and u.password = :password", Usuario.class)
					.setParameter("username", username)
					.setParameter("password", password)
					.getSingleResult();

		} catch (NoResultException e) {
			throw new AcessoNegadoException();
		}
	}

}
