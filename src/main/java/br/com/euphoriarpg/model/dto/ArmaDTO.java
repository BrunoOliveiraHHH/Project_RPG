package br.com.euphoriarpg.model.dto;

import lombok.Data;

@Data
public class ArmaDTO {

	private Long id;
	private String nome;
	private String custoMoeda;
	private String dadoTipoDano;
	private String peso;
	private String propriedades;
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
