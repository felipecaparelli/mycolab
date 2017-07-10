package br.com.caparelli.dao.impl;

import javax.persistence.NoResultException;

import br.com.caparelli.dao.UsuarioDAO;
import br.com.caparelli.exception.AcessoNegadoException;
import br.com.caparelli.model.Usuario;

public class UsuarioDAOImpl extends DAOImpl<Usuario> implements UsuarioDAO {

	private static final long serialVersionUID = 7503481134251639583L;

	@Override
	public Usuario login(String username, String password) throws AcessoNegadoException {

		try {

			return this.getEm()
					.createQuery("select from Usuario u where u.username = :username and u.password = :password", Usuario.class)
					.setParameter("username", username)
					.setParameter("password", password)
					.getSingleResult();

		} catch (NoResultException e) {
			throw new AcessoNegadoException();
		}
	}

}
