package br.com.caparelli.bo;

import java.util.List;

import br.com.caparelli.dto.ColaboradorDTO;
import br.com.caparelli.dto.DetalheColaboradorDTO;

/**
 * <b>Definicao</b>: Bo da entidade Colaborador
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	11 de jul de 2017
 *
 */
public interface ColaboradorBO  {

	public List<ColaboradorDTO> list();

	public DetalheColaboradorDTO findById(Integer id);

	public DetalheColaboradorDTO persist(DetalheColaboradorDTO dto);

	public void delete(DetalheColaboradorDTO dto);

}
