package br.com.caparelli.dto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.caparelli.model.Colaborador;
import br.com.caparelli.model.Competencia;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>Definicao</b>: DTO para a tela de detalhe do perfil do colaborador.
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	12 de jul de 2017
 *
 */
@Getter
@Setter
public class DetalheColaboradorDTO extends ColaboradorDTO {

	private static final long serialVersionUID = -3092858735033188532L;

	private String introducao;
	private byte[] avatar;
	private List<String> competencias;
	//private List<ContatoDTO> contatos;

	private String telefoneFixo;
	private String celular;
	private String email;
	private String facebook;
	private String linkedin;
	private String blog;

	/**
	 * @param entity
	 */
	public DetalheColaboradorDTO(Colaborador entity) {

		super(entity);

		if(entity != null) {

			this.introducao = entity.getIntroducao();
			this.avatar = entity.getAvatar();
			this.telefoneFixo = entity.getTelefoneFixo();
			this.celular = entity.getCelular();
			this.email = entity.getEmail();
			this.facebook = entity.getFacebook();
			this.linkedin = entity.getLinkedin();
			this.blog = entity.getBlog();

			List<Competencia> list = Optional.ofNullable(entity.getCompetencias()).orElse(Collections.emptyList());
			this.competencias = list.stream()
				.map(item -> item.getTag())
				.collect(Collectors.toList());

			/*List<ContatoColaborador> contatos = Optional.ofNullable(entity.getContatos()).orElse(Collections.emptyList());
			this.contatos = contatos.stream()
				.map(ContatoDTO::new)
				.collect(Collectors.toList());*/
		}
	}

}
