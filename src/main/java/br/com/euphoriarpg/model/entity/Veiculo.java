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
@Table(name = "VEICULO")
@Getter
@Setter
public class Veiculo {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "ID_VEICULO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "CUSTO_MOEDA")
	private String custoMoeda;

	@Column(name = "DESLOCAMENTO")
	private String deslocamento;

	@Column(name = "CARGA")
	private String carga;

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

	public String getDeslocamento() {
		return deslocamento;
	}

	public void setDeslocamento(String deslocamento) {
		this.deslocamento = deslocamento;
	}

	public String getCarga() {
		return carga;
	}

	public void setCarga(String carga) {
		this.carga = carga;
	}
}
