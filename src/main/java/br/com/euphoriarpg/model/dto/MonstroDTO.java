package br.com.euphoriarpg.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MonstroDTO {

	private Long id;
	private String nome;
	private String tipo;
	private String tamanho;
	private String tendencia;
	private String hp;
	private String ca;
	private String desloc_t;
	private String desloc_e;
	private String desloc_n;
	private String desloc_v;
	private String desloc_s;
	private String bp;
	private String str;
	private String dex;
	private String con;
	private String inte;
	private String wis;
	private String cha;
	private String nd;
	private String tracos;
	private String caracteristicas;
	private String acoes;
	private String acoeslendarias;
	private String acoesmiticas;
	private String usuario;

	@Override
	public String toString() {
		return "MonstroDTO [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", tamanho=" + tamanho + ", tendencia="
				+ tendencia + ", hp=" + hp + ", ca=" + ca + ", desloc_t=" + desloc_t + ", desloc_e=" + desloc_e
				+ ", desloc_n=" + desloc_n + ", desloc_v=" + desloc_v + ", desloc_s=" + desloc_s + ", bp=" + bp
				+ ", str=" + str + ", dex=" + dex + ", con=" + con + ", inte=" + inte + ", wis=" + wis + ", cha=" + cha
				+ ", nd=" + nd + ", tracos=" + tracos + ", caracteristicas=" + caracteristicas + ", acoes=" + acoes
				+ ", acoeslendarias=" + acoeslendarias + ", acoesmiticas=" + acoesmiticas + ", usuario=" + usuario
				+ "]";
	}

}
