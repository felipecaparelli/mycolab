package br.com.caparelli.view;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caparelli.bo.ColaboradorBO;
import br.com.caparelli.dto.DetalheColaboradorDTO;
import br.com.caparelli.util.MessageUtils;

/**
 * <b>Definicao</b>: Bean respons\u00e1vel por gerenciar a tela de detalhe do colaborador (readonly).
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

	public void init() {

		if(this.colaboradorId == null) {
			MessageUtils.errorI18n("requisicaoInvalida");
			return;
		}

		this.colaborador = this.colaboradorBO.findById(this.colaboradorId);
	}

	public String voltar() {
		return "home";
	}

	public void removerColaborador() {
		this.colaboradorBO.delete(this.colaborador);
		MessageUtils.info("Colaborador removido com sucesso");
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
