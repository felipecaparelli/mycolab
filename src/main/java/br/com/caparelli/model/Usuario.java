package br.com.caparelli.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * <b>Definicao</b>: Entidade que representa um usu\u00e1rio do sistema.
 *
 * <br>
 * <h1>Projeto: MyColab JSF</h1><br>
 *
 * @author Felipe Caparelli
 * @date 10 de jul de 2017
 *
 */
@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = -3850842450609995059L;

	@Id
    protected long id;

	private String username;
	private String password;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
