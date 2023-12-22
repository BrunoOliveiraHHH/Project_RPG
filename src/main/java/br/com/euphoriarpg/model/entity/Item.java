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
@Table(name = "ITEM")
@Getter
@Setter
public class Item {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "ID_ITEM")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "CUSTO_MOEDA")
	private String custoMoeda;

	@Column(name = "DESCRICAO")
	private String descricao;	
	
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
