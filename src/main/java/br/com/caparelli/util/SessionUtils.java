package br.com.caparelli.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <b>Definicao</b>: Classe utilit\u00e1ria para acesso aos dados da Sess\u00e3o.
 *
 * <br>
 * <h1>Projeto: MyColab JSF</h1><br>
 *
 * @author Felipe Caparelli
 * @date 10 de jul de 2017
 *
 */
public class SessionUtils {

	public static final String USERID = "userid";
	public static final String USERNAME = "username";

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public static String getUserName() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session.getAttribute(USERNAME).toString();
	}

	public static String getUserId() {
		HttpSession session = getSession();
		if (session != null) {
			return (String) session.getAttribute(USERID);
		} else {
			return null;
		}
	}

}
