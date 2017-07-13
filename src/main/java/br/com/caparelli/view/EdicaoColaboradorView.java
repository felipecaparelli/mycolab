package br.com.caparelli.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.caparelli.bo.CargoBO;
import br.com.caparelli.bo.ColaboradorBO;
import br.com.caparelli.bo.TipoContatoBO;
import br.com.caparelli.dto.CargoDTO;
import br.com.caparelli.dto.DetalheColaboradorDTO;
import br.com.caparelli.dto.TipoContatoDTO;
import br.com.caparelli.model.Colaborador;
import br.com.caparelli.util.MessageUtils;

/**
 * <b>Definicao</b>: Bean que gerencia a tela de edi\u00e7\u00e3o do colaborador
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	12 de jul de 2017
 *
 */
@ManagedBean
@ViewScoped
public class EdicaoColaboradorView implements Serializable {

	private static final long serialVersionUID = 5875663579762408893L;

	private Boolean isAlteracao;
	private Integer colaboradorId;
	private DetalheColaboradorDTO colaborador;
	private CargoDTO cargoSelecionado;
	private String competencias;

	private Integer executeAction;
	private UploadedFile file;

	private List<CargoDTO> cargos;

	private List<TipoContatoDTO> tipoContatoList;

	@EJB
	private ColaboradorBO colaboradorBO;

	@EJB
	private CargoBO cargoBO;

	@EJB
	private TipoContatoBO tipoContatoBO;

	public void preRender() {
		this.isAlteracao = (this.colaboradorId != null);

		this.cargos = this.cargoBO.list();

		if(this.isAlteracao) {

			this.colaborador = this.colaboradorBO.findById(this.colaboradorId);

			if(this.colaborador.getCargo() != null){
				this.cargoSelecionado = this.cargoBO.findByDescricao(this.colaborador.getCargo());
			}

			if(this.colaborador.getCompetencias() != null && !this.colaborador.getCompetencias().isEmpty()) {
				this.competencias = String.join(",", this.colaborador.getCompetencias());
			}
		} else {
			this.colaborador = new DetalheColaboradorDTO(new Colaborador());
		}
	}

	// --- Public Method

	public void handleFileUpload(FileUploadEvent event)
	{
		this.executeAction = null;
		MessageUtils.info("Sucesso", "O arquivo " + event.getFile().getFileName() + " foi enviado.");
    }

	public boolean isValid() {
		return (this.executeAction != null);
	}

	public void salvar(ActionEvent event) {

		if(this.cargoSelecionado != null) {
			this.colaborador.setCargo(this.cargoSelecionado.getDescricao());
		} else {
			MessageUtils.error("Favor informar o cargo!");
			return;
		}

		this.colaboradorBO.persist(this.colaborador);
		MessageUtils.info("Sucesso", "Usuário salvo com sucesso!");
	}


	/**
	 * @return the isAlteracao
	 */
	public Boolean getIsAlteracao() {
		return isAlteracao;
	}

	/**
	 * @param isAlteracao the isAlteracao to set
	 */
	public void setIsAlteracao(Boolean isAlteracao) {
		this.isAlteracao = isAlteracao;
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

	/**
	 * @return the cargoSelecionado
	 */
	public CargoDTO getCargoSelecionado() {
		return cargoSelecionado;
	}

	/**
	 * @param cargoSelecionado the cargoSelecionado to set
	 */
	public void setCargoSelecionado(CargoDTO cargoSelecionado) {
		this.cargoSelecionado = cargoSelecionado;
	}

	/**
	 * @return the file
	 */
	public UploadedFile getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(UploadedFile file) {
		this.file = file;
	}

	/**
	 * @return the cargos
	 */
	public List<CargoDTO> getCargos() {
		return cargos;
	}

	/**
	 * @param cargos the cargos to set
	 */
	public void setCargos(List<CargoDTO> cargos) {
		this.cargos = cargos;
	}

	/**
	 * @return the tipoContatoList
	 */
	public List<TipoContatoDTO> getTipoContatoList() {
		return tipoContatoList;
	}

	/**
	 * @param tipoContatoList the tipoContatoList to set
	 */
	public void setTipoContatoList(List<TipoContatoDTO> tipoContatoList) {
		this.tipoContatoList = tipoContatoList;
	}

	/**
	 * @return the competencias
	 */
	public String getCompetencias() {
		return competencias;
	}

	/**
	 * @param competencias the competencias to set
	 */
	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}



}
