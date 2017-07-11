package br.com.caparelli.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * <b>Definicao</b>: Essa entidade representa um funcion\u00e1rio da empresa.
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	10 de jul de 2017
 *
 */
@Data
@Entity
@Table(name="COLABORADOR")
public class Colaborador implements Serializable {

	private static final long serialVersionUID = -6594446143767506874L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cargo_id")
	private Cargo cargo;

}
