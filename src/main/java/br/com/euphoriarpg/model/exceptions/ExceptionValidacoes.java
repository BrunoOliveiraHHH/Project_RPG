package br.com.euphoriarpg.model.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionValidacoes {
	
	SEM_RETORNO_CONSULTA("Sem dados retornados da consulta!"),
	NAO_HA_OBJETO_CADASTRADO("Item pesquisado não encontrado!"),
	OBJETO_JA_EXISTENTE("Item já existe!");
	
	private String message;

}
