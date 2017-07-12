package br.com.caparelli.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caparelli.bo.ColaboradorBO;
import br.com.caparelli.dto.DetalheColaboradorDTO;
import br.com.caparelli.util.MessageUtils;

/**
 * <b>Definicao</b>: Bean respons\u00e1vel por gerenciar a tela de detalhe do colaborador.
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	12 de jul de 2017
 *
 */
@ManagedBean
@ViewScoped
public class DetalheColaboradorView implements Serializable {

	private static final long serialVersionUID = 218181072957994959L;

	private Integer colaboradorId;
	private DetalheColaboradorDTO colaborador;

	@EJB
	private ColaboradorBO colaboradorBO;

	@PostConstruct
	public void init() {
		//TODO carregar os dados do colaborador selecionado!
		if(this.colaboradorId == null) {
			MessageUtils.error("Requisi\u00e7\u00e3o inv\u00e1lida");
			return;
		}
	}

	public String voltar() {
		return "home";
	}



	/**
	 * @return the colaboradorId
	 */
	public Integer getColaboradorId() {
		return colaboradorId;
	}

	/**
	 * @param colaboradorId the colaboradorId to set
	 */
	public void setColaboradorId(Integer colaboradorId) {
		this.colaboradorId = colaboradorId;
	}

	/**
	 * @return the colaborador
	 */
	public DetalheColaboradorDTO getColaborador() {
		return colaborador;
	}

	/**
	 * @param colaborador the colaborador to set
	 */
	public void setColaborador(DetalheColaboradorDTO colaborador) {
		this.colaborador = colaborador;
	}



}
