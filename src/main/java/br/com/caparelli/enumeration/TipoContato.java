package br.com.caparelli.enumeration;

/**
 * <b>Definicao</b>: Enum que representa os poss\u00edveis tipos de contato do colaborador.
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @since   1.0
 * @date	11 de jul de 2017
 *
 */
public enum TipoContato {

	TELEFONE_FIXO("phone"),
	TELEFONE_CELULAR("mobile"),
	EMAIL("envelope-o"),
	FACEBOOK("facebook-official"),
	LINKEDIN("linkedin"),
	BLOG("wordpress");

	private String icone;

	TipoContato(String icone) {
		this.icone = icone;
	}

	/**
	 * @return the icone
	 */
	public String getIcone() {
		return icone;
	}


}
