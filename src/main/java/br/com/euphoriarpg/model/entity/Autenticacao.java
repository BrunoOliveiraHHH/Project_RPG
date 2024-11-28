package br.com.euphoriarpg.model.entity;

import java.time.LocalDateTime;

import br.com.euphoriarpg.model.enums.AtivoInativoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Getter
@Setter
@Table(name = "AUTENTICACAO")
public class Autenticacao {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "ID_AUTH")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "ID_USUARIO")
	private Long idUsuario;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "VALIDACAO")
	private String validacao;

	@Column(name = "DT_VALIDACAO")
	private LocalDateTime dataValidade;

	@Column(name = "SESSAO_ATIVA")
	private AtivoInativoEnum sessaoAtiva;

	@Column(name = "SESSAO_ENCERRADA", nullable = true)
	private AtivoInativoEnum sessaoEncerrada;

	@Override
	public String toString() {
		return "Autenticacao [id=" + id + ", idUsuario=" + idUsuario + ", login=" + login + ", validacao=" + validacao
				+ ", dataValidade=" + dataValidade + ", sessaoAtiva=" + sessaoAtiva + ", sessaoEncerrada="
				+ sessaoEncerrada + "]";
	}

}
