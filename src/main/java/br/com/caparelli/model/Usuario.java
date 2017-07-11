package br.com.caparelli.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * <b>Definicao</b>: Entidade que representa um usu\u00e1rio do sistema.
 *
 * <br>
 * <h1>Projeto: MyColab JSF</h1><br>
 *
 * @author Felipe Caparelli
 * @date 10 de jul de 2017
 *
 */
@Data
@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -3850842450609995059L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected long id;

	private String username;
	private String password;

}
