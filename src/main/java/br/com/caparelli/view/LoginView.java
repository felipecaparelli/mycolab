package br.com.caparelli.view;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import br.com.caparelli.dao.UsuarioDAO;
import br.com.caparelli.exception.AcessoNegadoException;
import br.com.caparelli.model.Usuario;
import br.com.caparelli.util.MessageUtils;
import br.com.caparelli.util.SessionUtils;

/**
 * <b>Definicao</b>: View para o login
 *
 * <br>
 * <h1>Projeto: MyColab JSF</h1><br>
 *
 * @author Felipe Caparelli
 * @date 10 de jul de 2017
 *
 */
@ManagedBean
@SessionScoped
public class LoginView implements Serializable {

	private static final long serialVersionUID = 7843092303007621313L;

	private String username;
	private String password;
	private String message;

	//TODO incluir CDI
	@EJB
	private UsuarioDAO loginDAO;

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

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public String login() {

		try {

			Usuario usuario = loginDAO.login(this.username, this.password);

			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", usuario.getUsername());

			return "home";

		} catch (AcessoNegadoException e) {
			MessageUtils.error("Usu\u00e1rio ou senha inv\u00e1lidos");
			return "login";
		}
	}

}
