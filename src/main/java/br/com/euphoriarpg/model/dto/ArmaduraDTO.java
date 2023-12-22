package br.com.euphoriarpg.model.dto;

import lombok.Data;

@Data
public class ArmaduraDTO {
	
	private Long id;
	private String nome;
	private String custoMoeda;
	private String classeDeArmadura;	
	private String forca;
	private String furtividade;
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
	public String getClasseDeArmadura() {
		return classeDeArmadura;
	}
	public void setClasseDeArmadura(String classeDeArmadura) {
		this.classeDeArmadura = classeDeArmadura;
	}
	public String getForca() {
		return forca;
	}
	public void setForca(String forca) {
		this.forca = forca;
	}
	public String getFurtividade() {
		return furtividade;
	}
	public void setFurtividade(String furtividade) {
		this.furtividade = furtividade;
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
