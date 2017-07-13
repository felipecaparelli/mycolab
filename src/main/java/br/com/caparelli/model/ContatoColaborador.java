package br.com.caparelli.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.caparelli.enumeration.TipoContato;
import lombok.Data;

/**
 * <b>Definicao</b>: Entidade que representa o contato do colaborador.
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	11 de jul de 2017
 *
 */
@Data
@Entity
@Table(name="CONTATO_COLABORADOR")
public class ContatoColaborador implements Serializable {

	private static final long serialVersionUID = 6613885188410420429L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private TipoContato tipo;

	@Column(nullable=false)
	private String contato;

	@ManyToOne(optional=false)
    @JoinColumn(name="colaborador_id")
	private Colaborador colaborador;

	public ContatoColaborador() {

	}

	public ContatoColaborador(TipoContato tipo, String contato, Colaborador colaborador) {
		this.tipo = tipo;
		this.contato = contato;
		this.colaborador = colaborador;
	}



}
