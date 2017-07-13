package br.com.caparelli.bo.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.caparelli.bo.ColaboradorBO;
import br.com.caparelli.dao.CargoDAO;
import br.com.caparelli.dao.ColaboradorDAO;
import br.com.caparelli.dto.ColaboradorDTO;
import br.com.caparelli.dto.DetalheColaboradorDTO;
import br.com.caparelli.model.Cargo;
import br.com.caparelli.model.Colaborador;
import br.com.caparelli.model.Competencia;

@Stateless
public class ColaboradorBOImpl implements ColaboradorBO {

	@EJB
	private ColaboradorDAO dao;

	@EJB
	private CargoDAO cargoDAO;

	/* (non-Javadoc)
	 * @see br.com.caparelli.bo.ColaboradorBO#list()
	 */
	@Override
	public List<ColaboradorDTO> list() {
		List<Colaborador> list = Optional.ofNullable(this.dao.list()).orElse(Collections.emptyList());
		return list.stream()
			.map(ColaboradorDTO::new)
			.collect(Collectors.toList());
	}

	/* (non-Javadoc)
	 * @see br.com.caparelli.bo.ColaboradorBO#findById(java.lang.Integer)
	 */
	@Override
	public DetalheColaboradorDTO findById(Integer id) {

		Colaborador colaborador = this.dao.find(id);

		if(colaborador == null) {
			return null;
		}

		return new DetalheColaboradorDTO(colaborador);
	}

	/* (non-Javadoc)
	 * @see br.com.caparelli.bo.ColaboradorBO#persist(br.com.caparelli.dto.DetalheColaboradorDTO)
	 */
	@Override
	public DetalheColaboradorDTO persist(DetalheColaboradorDTO dto) {

		Colaborador entity = (dto.getId() != null) ? this.dao.find(dto.getId()) : new Colaborador();

		entity.setNome(dto.getNome());
		entity.setIntroducao(dto.getIntroducao());

		preparaCargo(dto, entity);
		preparaCompetencias(dto, entity);
		//preparaContatos(dto, entity);

		if(entity.getId() == null) {
			this.dao.save(entity);
		} else {
			this.dao.update(entity);
		}

		return new DetalheColaboradorDTO(entity);
	}

	/**
	 * TODO: Explicar finalidade do método
	 *
	 * @param dto
	 * @param entity
	 */
	/*private void preparaContatos(DetalheColaboradorDTO dto, Colaborador entity) {
		if(dto.getContatos() != null && !dto.getContatos().isEmpty()) {
			entity.setContatos(new ArrayList<>(dto.getContatos().size()));
			for (ContatoDTO	contatoDTO : dto.getContatos()) {
				entity.getContatos().add(new ContatoColaborador(TipoContato.getByIcone(contatoDTO.getIcone()), contatoDTO.getContato(), entity));
			}
		}
	}*/

	/**
	 * TODO: Explicar finalidade do método
	 *
	 * @param dto
	 * @param entity
	 */
	private void preparaCargo(DetalheColaboradorDTO dto, Colaborador entity) {
		if(dto.getCargo() != null) {
			Cargo cargo = this.cargoDAO.findByDescricao(dto.getCargo());
			if(cargo != null) {
				entity.setCargo(cargo);
			}
		}
	}

	/**
	 * TODO: Explicar finalidade do método
	 *
	 * @param dto
	 * @param entity
	 */
	private void preparaCompetencias(DetalheColaboradorDTO dto, Colaborador entity) {
		if(dto.getCompetencias() != null) {
			if(entity.getCompetencias() == null) {
				entity.setCompetencias(new ArrayList<>(dto.getCompetencias().size()));
			}
			for (String competencia : dto.getCompetencias()) {
				entity.getCompetencias().add(new Competencia(competencia, entity));
			}
		} else {
			entity.setCompetencias(new ArrayList<>());
		}
	}

	/* (non-Javadoc)
	 * @see br.com.caparelli.bo.ColaboradorBO#delete(br.com.caparelli.dto.DetalheColaboradorDTO)
	 */
	@Override
	public void delete(DetalheColaboradorDTO dto) {

		if(dto.getId() == null) {
			throw new IllegalArgumentException("ID do colaborador n\u00e3o informado");
		}

		Colaborador entity = this.dao.find(dto.getId());

		/*
		 * TODO verificar se os relacionamentos foram removidos corretamente;
		 */

		this.dao.remove(entity);
	}

}
