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
@Table(name = "ARMADURA")
@Getter
@Setter
public class Armadura {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "ID_ARMADURA")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "CUSTO_MOEDA")
	private String custoMoeda;

	@Column(name = "CA")
	private String classeDeArmadura;	

	@Column(name = "FORCA")
	private String forca;
	
	@Column(name = "FURTIVIDADE")
	private String furtividade;
	
	@Column(name = "PESO")
	private String peso;
	
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
