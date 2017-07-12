package br.com.caparelli.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * <b>Definicao</b>: Entidade que representa a compent\u00eancia do colaborador;
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	11 de jul de 2017
 *
 */
@Data
@Entity
@Table(name="COMPETENCIA")
public class Competencia implements Serializable {

	private static final long serialVersionUID = 3731343658588629870L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String tag;

	@ManyToOne(optional=false)
    @JoinColumn(name="colaborador_id")
	private Colaborador colaborador;

}
