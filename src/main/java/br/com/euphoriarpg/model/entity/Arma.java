package br.com.euphoriarpg.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ARMA")
public class Arma {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "ID_ARMA")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "CUSTO_MOEDA")
	private String custoMoeda;

	@Column(name = "DANO_TIPO_DANO")
	private String dadoTipoDano;

	@Column(name = "PESO")
	private String peso;

	@Column(name = "PROPRIEDADES")
	private String propriedades;

	@Column(name = "OBSERVACAO")
	private String observacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCustoMoeda() {
		return custoMoeda;
	}

	public void setCustoMoeda(String custoMoeda) {
		this.custoMoeda = custoMoeda;
	}

	public String getDadoTipoDano() {
		return dadoTipoDano;
	}

	public void setDadoTipoDano(String dadoTipoDano) {
		this.dadoTipoDano = dadoTipoDano;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(String propriedades) {
		this.propriedades = propriedades;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
