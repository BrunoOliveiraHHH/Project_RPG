package br.com.euphoriarpg.model.entity;

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
@Table(name = "MONSTRO")
@Getter
@Setter
public class Monstro {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "ID_MONSTRO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "TIPO_CRIATURA")
	private String tipoCriatura;

	@Column(name = "TAMANHO")
	private String tamanho;	

	@Column(name = "TENDENCIA")
	private String tendencia;
	
	@Column(name = "PONTOS_DE_VIDA")
	private String pontosDeVida;
	
	@Column(name = "CLASSE_ARMADURA")
	private String classeArmadura;
	
	@Column(name = "DESLOCAMENTO")
	private String deslocamento;

}
