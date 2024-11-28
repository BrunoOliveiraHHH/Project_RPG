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
@Getter
@Setter
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

	@Override
	public String toString() {
		return "Arma [id=" + id + ", nome=" + nome + ", custoMoeda=" + custoMoeda + ", dadoTipoDano=" + dadoTipoDano
				+ ", peso=" + peso + ", propriedades=" + propriedades + ", observacao=" + observacao + "]";
	}

}
