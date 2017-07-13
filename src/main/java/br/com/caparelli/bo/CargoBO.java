package br.com.caparelli.bo;

import java.util.List;

import br.com.caparelli.dto.CargoDTO;

/**
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	12 de jul de 2017
 *
 */
public interface CargoBO {

	public List<CargoDTO> list();

	public CargoDTO findByDescricao(String descricao);

}
