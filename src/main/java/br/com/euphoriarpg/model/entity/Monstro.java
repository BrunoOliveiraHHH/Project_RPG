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

	@Column(name = "TIPO")
	private String tipo;

	@Column(name = "TAMANHO")
	private String tamanho;

	@Column(name = "TENDENCIA")
	private String tendencia;

	@Column(name = "PV")
	private String hp;

	@Column(name = "CA")
	private String ca;

	@Column(name = "DESLOCAMENTO_TERRESTRE")
	private String desloc_t;
	
	@Column(name = "DESLOCAMENTO_ESCALADA")
	private String desloc_e;
	
	@Column(name = "DESLOCAMENTO_NATACAO")
	private String desloc_n;
	
	@Column(name = "DESLOCAMENTO_VOO")
	private String desloc_v;
	
	@Column(name = "DESLOCAMENTO_SUBTERRANEO")
	private String desloc_s;

	@Column(name = "BONUS_PROFICIENCIA")
	private String bp;
	@Column(name = "FORCA")
	private String str;
	@Column(name = "DESTREZA")
	private String dex;
	@Column(name = "CONSTITUICAO")
	private String con;
	@Column(name = "INTELIGENCIA")
	private String inte;
	@Column(name = "SABEDORIA")
	private String wis;
	@Column(name = "CARISMA")
	private String cha;
	@Column(name = "NIVEL_DIFICULDADE")
	private String nd;

	@Column(name = "TRACOS", columnDefinition = "TEXT")
	private String tracos;
	
	@Column(name = "CARACTERISTICAS", columnDefinition = "TEXT")
	private String caracteristicas;

	@Column(name = "ACOES", columnDefinition = "TEXT")
	private String acoes;

	@Column(name = "ACOES_LENDARIAS", columnDefinition = "TEXT")
	private String acoeslendarias;
	
	@Column(name = "ACOES_MITICAS", columnDefinition = "TEXT")
	private String acoesmiticas;
	
}
