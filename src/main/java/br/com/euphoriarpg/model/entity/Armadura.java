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

	@Override
	public String toString() {
		return "Armadura [id=" + id + ", nome=" + nome + ", custoMoeda=" + custoMoeda + ", classeDeArmadura="
				+ classeDeArmadura + ", forca=" + forca + ", furtividade=" + furtividade + ", peso=" + peso
				+ ", observacao=" + observacao + "]";
	}
}
