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
@Table(name = "NPC")
public class Npc {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "ID_NPC")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "IDADE")
	private String idade;

	@Column(name = "RACA")
	private String raca;

	@Column(name = "CLASSE")
	private String classe;

	@Override
	public String toString() {
		return "Npc [id=" + id + ", nome=" + nome + ", idade=" + idade + ", raca=" + raca + ", classe=" + classe + "]";
	}

}
