package br.com.caparelli.exception;

/**
 * <b>Definicao</b>: Exce\u00e7\u00e3o para erros de valida\u00e7\u00e3o de dados.
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	10 de jul de 2017
 *
 */
public class ValidacaoException extends RuntimeException {

	private static final long serialVersionUID = -658318550580288322L;

	public static final String GENERIC_MESSAGE = "Erro de valida\u00e7\u00e3o ";

	public ValidacaoException() {
		super(GENERIC_MESSAGE);
	}

	/**
	 * @param t entidade onde ocorreu o erro.
	 */
	public ValidacaoException(Object t) {
		super(GENERIC_MESSAGE + ": " + t);
	}

}
