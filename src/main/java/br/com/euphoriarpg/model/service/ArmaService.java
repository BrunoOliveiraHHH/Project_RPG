package br.com.euphoriarpg.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ArmaDTO;
import br.com.euphoriarpg.model.entity.Arma;

@Service
public interface ArmaService {

	List<Arma> getAll();

	Arma getArma(Long id);

	Arma create(ArmaDTO dtoInput);

	Arma update(ArmaDTO dtoInput);

	void delete(Long id);

}
