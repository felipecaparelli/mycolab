package br.com.caparelli.view;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.caparelli.util.MessageUtils;

/**
 * <b>Definicao</b>: Bean que gerencia a tela de edição do colaborador
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	12 de jul de 2017
 *
 */
public class EdicaoColaboradorView {

	private Integer executeAction;
	private UploadedFile file;

	// --- Public Method

	public void handleFileUpload(FileUploadEvent event)
	{
		this.executeAction = null;
		MessageUtils.info("Sucesso", "O arquivo " + event.getFile().getFileName() + " foi enviado.");
    }

	public boolean isValid() {
		return (this.executeAction != null);
	}

	// --- Getters / Setters

	public UploadedFile getFile() {
		return file;
	}

	public Integer getExecuteAction() {
		return executeAction;
	}

	public void setExecuteAction(Integer executeAction) {
		this.executeAction = executeAction;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

}
