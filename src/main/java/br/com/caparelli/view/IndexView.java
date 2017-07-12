package br.com.caparelli.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caparelli.bo.ColaboradorBO;
import br.com.caparelli.dto.ColaboradorDTO;
import br.com.caparelli.util.SessionUtils;

/**
 * <b>Definicao</b>: View da tela index.xhtml
 *
 * <br>
 * <h1>Projeto: MyColab JSF</h1><br>
 *
 * @author Felipe Caparelli
 * @date 11 de jul de 2017
 *
 */
@ManagedBean
@ViewScoped
public class IndexView implements Serializable {

	private static final long serialVersionUID = 2559809903163707567L;

	@EJB
	private ColaboradorBO colaboradorBO;

	private String busca;

	private List<ColaboradorDTO> lista;

	@PostConstruct
	public void init() {
		this.lista = colaboradorBO.list();
	}

	/**
	 * Finaliza a sess\u00e3o do usu\u00e1rio logado.
	 *
	 * @return action para a tela de login
	 */
	public String logout() {

		SessionUtils.getSession().invalidate();

		return "login";
	}

	/**
	 * @return the busca
	 */
	public String getBusca() {
		return busca;
	}

	/**
	 * @param busca
	 *            the busca to set
	 */
	public void setBusca(String busca) {
		this.busca = busca;
	}

	/**
	 * @return the lista
	 */
	public List<ColaboradorDTO> getLista() {
		return lista;
	}

	/**
	 * @param lista
	 *            the lista to set
	 */
	public void setLista(List<ColaboradorDTO> lista) {
		this.lista = lista;
	}

}
