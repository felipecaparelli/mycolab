package br.com.caparelli.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * <b>Definicao</b>: Entidade que representa o setor do colaborador.
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	11 de jul de 2017
 *
 */
@Data
@Entity
@Table(name="SETOR")
public class Setor implements Serializable {

	private static final long serialVersionUID = -2803057501807587461L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(nullable=false)
	private String nome;

	private String icone;

}
