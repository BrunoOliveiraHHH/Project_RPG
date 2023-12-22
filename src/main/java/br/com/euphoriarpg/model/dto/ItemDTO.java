package br.com.euphoriarpg.model.dto;

import lombok.Data;

@Data
public class ItemDTO {
	
	private Long id;
	private String nome;
	private String custoMoeda;
	private String descricao;	
	private String peso;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
