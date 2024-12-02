package br.com.euphoriarpg.model.entity;

import java.time.LocalDateTime;

import br.com.euphoriarpg.model.enums.AcaoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "LOG_AUDITORIA")
@Getter
@Setter
public class LogAuditoria {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "ID_LOG")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "CLASSE")
	private String classe;

	@Column(name = "OBJ_ORIGINAL")
	private String objOriginal;

	@Column(name = "OBJ_NOVO")
	private String objNovo;

	@Column(name = "ACAO")
	@Enumerated(EnumType.STRING)
	private AcaoEnum acao;

	@Column(name = "DT_EVENTO")
	private LocalDateTime dataEvento;

	@Column(name = "USU_EVENTO")
	private String usuarioEvento;

	public LogAuditoria(String classe, String objOriginal, String objNovo, AcaoEnum acao, LocalDateTime dataEvento,
			String usuarioEvento) {
		this.classe = classe;
		this.objOriginal = objOriginal;
		this.objNovo = objNovo;
		this.acao = acao;
		this.dataEvento = dataEvento;
		this.usuarioEvento = usuarioEvento;
	}

	public LogAuditoria() {
	}

}
